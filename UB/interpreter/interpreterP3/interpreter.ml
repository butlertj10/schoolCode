type stackValue = BOOL of bool | INT of int | ERROR | STRING of string | NAME of string | UNIT  
type command  = ADD | SUB | MUL | DIV | REM | NEG | SWAP | TOSTRING | PRINTLN | POP | QUIT |
                PUSH of stackValue | CAT | AND | OR | NOT | EQUAL | LESSTHAN | BIND | IF | LET | END |
                CALL | RETURN | FUNEND | FUN of stackValue * stackValue 

exception NoStr of string;;
exception NoString of string;;

let interpreter ( (input : string), (output : string )) : unit = 
  
  let ic = open_in input in  

  let oc = open_out output in 

  let rec loop_read acc =
      try 
          let l = String.trim(input_line ic) in loop_read (l::acc)
      with
      | End_of_file -> List.rev acc in
      
  let file_write string_val = Printf.fprintf oc "%s\n" string_val in      

  let strList = loop_read [] in
  
  let ch_ls = ['A'; 'B'; 'C'; 'D'; 'E'; 'F'; 'G'; 'H'; 'I'; 'J'; 'K';
              'L'; 'M'; 'N'; 'O'; 'P'; 'Q'; 'R'; 'S'; 'T'; 'U'; 'V';
              'W'; 'X'; 'Y'; 'Z';'a'; 'b'; 'c'; 'd'; 'e'; 'f'; 'g'; 'h'; 'i'; 'j'; 'k';
              'l'; 'm'; 'n'; 'o'; 'p'; 'q'; 'r'; 's'; 't'; 'u'; 'v';
              'w'; 'x'; 'y'; 'z'; '_'] in
              
  let num_ls = ['0'; '1'; '2'; '3'; '4'; '5'; '6'; '7'; '8'; '9' ; '-'] in

  (* checks if stackValue is a name*)
  let rec check_name str ch_list =
    match ch_list with
    | [] ->  "false"
    | c::rest_chs -> if String.contains str c
                     then "true"
                     else check_name str rest_chs in
    
  (* checks if stackValue is a number *)
  let rec check_num str num_list =
    match num_list with
    | [] -> "false"
    | c::rest_num -> if String.contains str c
                     then "true"
                     else check_num str rest_num in
   
  let stringToStackValue s = 
    match s with
      | ":true:" -> BOOL(bool_of_string(String.sub s 1 4))
      | ":false:" -> BOOL(bool_of_string(String.sub s 1 5))
      | ":unit:" -> UNIT
      | ":error:" -> ERROR
      | _ -> let char1 = String.get s 0 in
                match char1 with
                  | '"' -> STRING(String.sub s 1 (String.length s - 2))
                  | _ -> if check_name (Char.escaped char1) ch_ls = "true"  
                         then NAME(s)
                         else if check_num (Char.escaped char1) num_ls = "true" 
                         then if String.contains s '.'
                              then ERROR
                              else INT(int_of_string s)
                         else raise (NoString s) in
                         
  let stringToCommand s = 
    match s with
      | "add" -> ADD
      | "sub" -> SUB
      | "mul" -> MUL
      | "div" -> DIV
      | "rem" -> REM
      | "neg" -> NEG
      | "swap" -> SWAP
      | "pop" -> POP
      | "quit" -> QUIT
      | "toString" -> TOSTRING
      | "println" -> PRINTLN 
      | "cat" -> CAT
      | "and" -> AND
      | "or" -> OR 
      | "not" -> NOT 
      | "equal" -> EQUAL
      | "lessThan" -> LESSTHAN
      | "bind" -> BIND
      | "if" -> IF
      | "let" -> LET
      | "end" -> END 
      | _ -> let subStr = String.sub s 0 4 in 
                  if subStr = "push"
                  then let subStr2 = (String.sub s 5 (String.length s - 5))in PUSH(stringToStackValue subStr2)
				  else let subStr = String.sub s 0 3 in 
                  if subStr = "fun"
                  then let subStr3 = (String.sub s 5 (String.length s - 5))in FUN(stackValuetoString stringToStackValue subStr3)
                  else raise (NoStr s) in
  
  let stackValuetoString (sv : stackValue) : string =
    match sv with
    | BOOL (tf) -> ":" ^ string_of_bool tf ^ ":"
    | INT (num) -> string_of_int num
    | ERROR -> ":error:"
    | NAME (name) -> name
    | STRING (str) -> str
    | UNIT -> ":unit:"
  in

  let commandList = List.map stringToCommand strList
  in
  
let rec look name env =
    match env with
    | [] -> None 
	  | []::x -> look name x 
    | ((NAME(x),y)::a)::b -> if x = name 
                   then Some y
                   else look name (a::b)
    | _::b -> look name b in
  
  let rec processor cl stack env = 
    match (cl, stack, env) with 
    | ADD::restOfCL, (INT(a)::INT(b)::restOfStack)::stl,((env)::etl) -> processor restOfCL ((INT(b+a)::restOfStack)::stl) ((env)::etl)    
    | ADD::restOfCL, (NAME(a)::INT(b)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(y) -> processor restOfCL ((INT(b+y)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::INT(b)::restOfStack)::stl) ((env)::etl))
    | ADD::restOfCL, (INT(a)::NAME(b)::restOfStack)::stl,((env)::etl) -> (match look b ((env)::etl) with 
                                                                | Some INT(y) -> processor restOfCL ((INT(y+a)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::INT(a)::NAME(b)::restOfStack)::stl) ((env)::etl))                            
    | ADD::restOfCL, (NAME(a)::NAME(b)::restOfStack)::stl,((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(x) -> (match look b ((env)::etl) with 
                                                                                 | Some INT(y) -> processor restOfCL ((INT(y+x)::restOfStack)::stl) ((env)::etl)
                                                                                 | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))
    | SUB::restOfCL, (INT(a)::INT(b)::restOfStack)::stl,((env)::etl) -> processor restOfCL ((INT(b-a)::restOfStack)::stl) ((env)::etl)
    | SUB::restOfCL, (NAME(a)::INT(b)::restOfStack)::stl,((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(y) -> processor restOfCL ((INT(b-y)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::INT(b)::restOfStack)::stl) ((env)::etl))
    | SUB::restOfCL, (INT(a)::NAME(b)::restOfStack)::stl,((env)::etl) -> (match look b ((env)::etl) with 
                                                                | Some INT(y) -> processor restOfCL ((INT(y-a)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::INT(a)::NAME(b)::restOfStack)::stl) ((env)::etl))                            
    | SUB::restOfCL, (NAME(a)::NAME(b)::restOfStack)::stl,((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(x) -> (match look b ((env)::etl) with 
                                                                                 | Some INT(y) -> processor restOfCL ((INT(y-x)::restOfStack)::stl) ((env)::etl)
                                                                                 | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))    
    | MUL::restOfCL, (INT(a)::INT(b)::restOfStack)::stl,((env)::etl) -> processor restOfCL ((INT(b*a)::restOfStack)::stl) ((env)::etl)
    | MUL::restOfCL, (NAME(a)::INT(b)::restOfStack)::stl,((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(y) -> processor restOfCL ((INT(b*y)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::INT(b)::restOfStack)::stl) ((env)::etl))
    | MUL::restOfCL, (INT(a)::NAME(b)::restOfStack)::stl,((env)::etl) -> (match look b ((env)::etl) with 
                                                                | Some INT(y) -> processor restOfCL ((INT(y*a)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::INT(a)::NAME(b)::restOfStack)::stl) ((env)::etl))                            
    | MUL::restOfCL, (NAME(a)::NAME(b)::restOfStack)::stl,((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(x) -> (match look b ((env)::etl) with 
                                                                                 | Some INT(y) -> processor restOfCL ((INT(y*x)::restOfStack)::stl) ((env)::etl)
                                                                                 | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))    
    | DIV::restOfCL, (INT(0)::restOfStack)::stl,((env)::etl) -> processor restOfCL ((ERROR::INT(0)::restOfStack)::stl) ((env)::etl)
    | DIV::restOfCL, (INT(a)::INT(b)::restOfStack)::stl,((env)::etl) -> processor restOfCL ((INT(b/a)::restOfStack)::stl) ((env)::etl)
    | DIV::restOfCL, (NAME(a)::INT(b)::restOfStack)::stl,((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(0) -> processor restOfCL ((ERROR::NAME(a)::INT(b)::restOfStack)::stl) ((env)::etl)
                                                                | Some INT(y) -> processor restOfCL ((INT(b/y)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::INT(b)::restOfStack)::stl) ((env)::etl))
    | DIV::restOfCL, (INT(a)::NAME(b)::restOfStack)::stl,((env)::etl) -> (match look b ((env)::etl) with 
                                                                | Some INT(y) -> processor restOfCL ((INT(y/a)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::INT(a)::NAME(b)::restOfStack)::stl) ((env)::etl))                            
    | DIV::restOfCL, (NAME(a)::NAME(b)::restOfStack)::stl,((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(0) -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl)
                                                                | Some INT(x) -> (match look b ((env)::etl) with 
																                 | Some INT(0) -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl)
                                                                                 | Some INT(y) -> processor restOfCL ((INT(y/x)::restOfStack)::stl) ((env)::etl)
                                                                                 | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))    
    | REM::restOfCL, (INT(0)::restOfStack)::stl,((env)::etl) -> processor restOfCL ((ERROR::INT(0)::restOfStack)::stl) ((env)::etl)
    | REM::restOfCL, (INT(a)::INT(b)::restOfStack)::stl,((env)::etl) -> processor restOfCL ((INT(b mod a)::restOfStack)::stl) ((env)::etl)
    | REM::restOfCL, (NAME(a)::INT(b)::restOfStack)::stl,((env)::etl) -> (match look a ((env)::etl) with 
	                                                            | Some INT(0) -> processor restOfCL ((ERROR::NAME(a)::INT(b)::restOfStack)::stl) ((env)::etl)
                                                                | Some INT(y) -> processor restOfCL ((INT(b mod y)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::INT(b)::restOfStack)::stl) ((env)::etl))
    | REM::restOfCL, (INT(a)::NAME(b)::restOfStack)::stl,((env)::etl) -> (match look b ((env)::etl) with 
                                                                | Some INT(y) -> processor restOfCL ((INT(y mod a)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::INT(a)::NAME(b)::restOfStack)::stl) ((env)::etl))                            
    | REM::restOfCL, (NAME(a)::NAME(b)::restOfStack)::stl,((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(0) -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl)
                                                                | Some INT(x) -> (match look b ((env)::etl) with 
																                 | Some INT(0) -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl)
                                                                                 | Some INT(y) -> processor restOfCL ((INT(y mod x)::restOfStack)::stl) ((env)::etl)
                                                                                 | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))    
    | NEG::restOfCL, (INT(a)::restOfStack)::stl,((env)::etl) -> processor restOfCL ((INT(-a)::restOfStack)::stl) ((env)::etl)
    | NEG::restOfCL, (NAME(a)::restOfStack)::stl,((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(y) -> processor restOfCL ((INT(-y)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::restOfStack)::stl) ((env)::etl))    
    | SWAP::restOfCL, (a::b::restOfStack)::stl,((env)::etl) -> processor restOfCL ((b::a::restOfStack)::stl) ((env)::etl)
    | POP::restOfCL, (a::restOfStack)::stl,((env)::etl) -> processor restOfCL ((restOfStack)::stl) ((env)::etl)  
    | TOSTRING::restOfCL, (a::restOfStack)::stl,((env)::etl) -> processor restOfCL ((STRING(stackValuetoString a)::restOfStack)::stl) ((env)::etl)
    | PRINTLN::restOfCL, (STRING(a)::restOfStack)::stl,((env)::etl) -> file_write a ; processor restOfCL ((restOfStack)::stl) ((env)::etl)
    | PUSH(stkVal)::restOfCL, ((restOfStack)::stl),((env)::etl) -> processor restOfCL ((stkVal::restOfStack)::stl) ((env)::etl)
    | QUIT::restOfCL, stack, ((env)::etl) -> stack    
    | CAT::restOfCL, (STRING(a)::STRING(b)::restOfStack)::stl, ((env)::etl) -> processor restOfCL ((STRING(b^a)::restOfStack)::stl) ((env)::etl)
    | CAT::restOfCL, (NAME(a)::STRING(b)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some STRING(y) -> processor restOfCL ((STRING(b^y)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::STRING(b)::restOfStack)::stl) ((env)::etl))
    | CAT::restOfCL, (STRING(a)::NAME(b)::restOfStack)::stl, ((env)::etl) -> (match look b ((env)::etl) with 
                                                                | Some STRING(y) -> processor restOfCL ((STRING(y^a)::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::STRING(a)::NAME(b)::restOfStack)::stl) ((env)::etl))                                                            
    | CAT::restOfCL, (NAME(a)::NAME(b)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some STRING(x) -> (match look b ((env)::etl) with 
                                                                                     | Some STRING(y) -> processor restOfCL ((STRING(y^x)::restOfStack)::stl) ((env)::etl)
                                                                                     | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))    
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))                                                            
    | AND::restOfCL, (BOOL(a)::BOOL(b)::restOfStack)::stl, ((env)::etl) -> if(a = true && b = true)
                                                                 then let andVar = true in processor restOfCL ((BOOL (andVar)::restOfStack)::stl) ((env)::etl)
                                                                 else let andVar = false in processor restOfCL ((BOOL (andVar)::restOfStack)::stl) ((env)::etl)
    | AND::restOfCL, (NAME(a)::BOOL(b)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some BOOL(y) -> if(y = true && b = true)
                                                                                    then let andVar = true in processor restOfCL ((BOOL (andVar)::restOfStack)::stl) ((env)::etl)
                                                                                    else let andVar = false in processor restOfCL ((BOOL (andVar)::restOfStack)::stl) ((env)::etl)        
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::BOOL(b)::restOfStack)::stl) ((env)::etl))
    | AND::restOfCL, (BOOL(a)::NAME(b)::restOfStack)::stl, ((env)::etl) -> (match look b ((env)::etl) with 
                                                                | Some BOOL(y) -> if(y = true && a = true)
                                                                                    then let andVar = true in processor restOfCL ((BOOL (andVar)::restOfStack)::stl) ((env)::etl)
                                                                                    else let andVar = false in processor restOfCL ((BOOL (andVar)::restOfStack)::stl) ((env)::etl)        
                                                                | _ -> processor restOfCL ((ERROR::BOOL(a)::NAME(b)::restOfStack)::stl) ((env)::etl))
    | AND::restOfCL, (NAME(a)::NAME(b)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some BOOL(x) -> (match look a ((env)::etl) with
                                                                                  | Some BOOL(y) -> if(y = true && x = true)
                                                                                                    then let andVar = true in processor restOfCL ((BOOL (andVar)::restOfStack)::stl) ((env)::etl)
                                                                                                    else let andVar = false in processor restOfCL ((BOOL (andVar)::restOfStack)::stl) ((env)::etl)        
                                                                                  | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))        
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))    
    | OR::restOfCL, (BOOL(a)::BOOL(b)::restOfStack)::stl, ((env)::etl) -> if(a = false && b = false)
                                                                 then let orVar = false in processor restOfCL ((BOOL (orVar)::restOfStack)::stl) ((env)::etl)
                                                                 else let orVar = true in processor restOfCL ((BOOL (orVar)::restOfStack)::stl) ((env)::etl)
    | OR::restOfCL, (NAME(a)::BOOL(b)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some BOOL(y) -> if(y = false && b = false)
                                                                                    then let orVar = false in processor restOfCL ((BOOL (orVar)::restOfStack)::stl) ((env)::etl)
                                                                                    else let orVar = true in processor restOfCL ((BOOL (orVar)::restOfStack)::stl) ((env)::etl)        
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::BOOL(b)::restOfStack)::stl) ((env)::etl))
    | OR::restOfCL, (BOOL(a)::NAME(b)::restOfStack)::stl, ((env)::etl) -> (match look b ((env)::etl) with 
                                                                | Some BOOL(y) -> if(y = false && a = false)
                                                                                    then let orVar = false in processor restOfCL ((BOOL (orVar)::restOfStack)::stl) ((env)::etl)
                                                                                    else let orVar = true in processor restOfCL ((BOOL (orVar)::restOfStack)::stl) ((env)::etl)        
                                                                | _ -> processor restOfCL ((ERROR::BOOL(a)::NAME(b)::restOfStack)::stl) ((env)::etl))
    | OR::restOfCL, (NAME(a)::NAME(b)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some BOOL(x) -> (match look a ((env)::etl) with
                                                                                  | Some BOOL(y) -> if(y = false && x = false)
                                                                                                    then let orVar = false in processor restOfCL ((BOOL (orVar)::restOfStack)::stl) ((env)::etl)
                                                                                                    else let orVar = true in processor restOfCL ((BOOL (orVar)::restOfStack)::stl) ((env)::etl)        
                                                                                  | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))        
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))    
    | NOT::restOfCL, (BOOL(a)::restOfStack)::stl, ((env)::etl) -> if(a = true)
                                                      then let notVar = false in processor restOfCL ((BOOL (notVar)::restOfStack)::stl) ((env)::etl)
                                                      else let notVar = true in processor restOfCL ((BOOL (notVar)::restOfStack)::stl) ((env)::etl)
    | NOT::restOfCL, (NAME(a)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some BOOL(y) -> if(y = true)
                                                                                  then let notVar = false in processor restOfCL ((BOOL (notVar)::restOfStack)::stl) ((env)::etl)
                                                                                  else let notVar = true in processor restOfCL ((BOOL (notVar)::restOfStack)::stl) ((env)::etl)    
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::restOfStack)::stl) ((env)::etl))
    | EQUAL::restOfCL, (INT(a)::INT(b)::restOfStack)::stl, ((env)::etl) -> if(a = b)
                                                                 then let equalVar = true in processor restOfCL ((BOOL (equalVar)::restOfStack)::stl) ((env)::etl)
                                                                 else let equalVar = false in processor restOfCL ((BOOL (equalVar)::restOfStack)::stl) ((env)::etl)
    | EQUAL::restOfCL, (NAME(a)::INT(b)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(y) -> if(y = b)
                                                                                  then let equalVar = true in processor restOfCL ((BOOL (equalVar)::restOfStack)::stl) ((env)::etl)
                                                                                  else let equalVar = false in processor restOfCL ((BOOL (equalVar)::restOfStack)::stl) ((env)::etl)    
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::INT(b)::restOfStack)::stl) ((env)::etl))                                                             
    | EQUAL::restOfCL, (INT(a)::NAME(b)::restOfStack)::stl, ((env)::etl) -> (match look b ((env)::etl) with 
                                                                | Some INT(y) -> if(y = a)
                                                                                  then let equalVar = true in processor restOfCL ((BOOL (equalVar)::restOfStack)::stl) ((env)::etl)
                                                                                  else let equalVar = false in processor restOfCL ((BOOL (equalVar)::restOfStack)::stl) ((env)::etl)    
                                                                | _ -> processor restOfCL ((ERROR::INT(a)::NAME(b)::restOfStack)::stl) ((env)::etl))                                                                         
    | EQUAL::restOfCL, (NAME(a)::NAME(b)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(x) -> (match look b ((env)::etl) with 
                                                                                | Some INT(y) -> if(y = x)
                                                                                                 then let equalVar = true in processor restOfCL ((BOOL (equalVar)::restOfStack)::stl) ((env)::etl)
                                                                                                 else let equalVar = false in processor restOfCL ((BOOL (equalVar)::restOfStack)::stl) ((env)::etl)    
                                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))        
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))            
    | LESSTHAN::restOfCL, (INT(a)::INT(b)::restOfStack)::stl, ((env)::etl) -> if(b < a)
                                                                    then let lessVar = true in processor restOfCL ((BOOL (lessVar)::restOfStack)::stl) ((env)::etl)
                                                                    else let lessVar = false in processor restOfCL ((BOOL (lessVar)::restOfStack)::stl) ((env)::etl)
    | LESSTHAN::restOfCL, (NAME(a)::INT(b)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(y) -> if(b < y)
                                                                                  then let lessVar = true in processor restOfCL ((BOOL (lessVar)::restOfStack)::stl) ((env)::etl)
                                                                                  else let lessVar = false in processor restOfCL ((BOOL (lessVar)::restOfStack)::stl) ((env)::etl)    
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::INT(b)::restOfStack)::stl) ((env)::etl))                                                             
    | LESSTHAN::restOfCL, (INT(a)::NAME(b)::restOfStack)::stl, ((env)::etl) -> (match look b ((env)::etl) with 
                                                                | Some INT(y) -> if(y < a)
                                                                                  then let lessVar = true in processor restOfCL ((BOOL (lessVar)::restOfStack)::stl) ((env)::etl)
                                                                                  else let lessVar = false in processor restOfCL ((BOOL (lessVar)::restOfStack)::stl) ((env)::etl)    
                                                                | _ -> processor restOfCL ((ERROR::INT(a)::NAME(b)::restOfStack)::stl) ((env)::etl))                                                                         
    | LESSTHAN::restOfCL, (NAME(a)::NAME(b)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with 
                                                                | Some INT(x) -> (match look b ((env)::etl) with 
                                                                                | Some INT(y) -> if(y < x)
                                                                                  then let lessVar = true in processor restOfCL ((BOOL (lessVar)::restOfStack)::stl) ((env)::etl)
                                                                                  else let lessVar = false in processor restOfCL ((BOOL (lessVar)::restOfStack)::stl) ((env)::etl)    
                                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))        
                                                                | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))                                                                
    | IF::restOfCL, (a::b::BOOL(c)::restOfStack)::stl, ((env)::etl) -> if(c = true)
                                                               then processor restOfCL ((a::restOfStack)::stl) ((env)::etl)
                                                               else processor restOfCL ((b::restOfStack)::stl) ((env)::etl)
    | IF::restOfCL, (a::b::NAME(c)::restOfStack)::stl, ((env)::etl) -> (match look c ((env)::etl) with 
                                                                | Some BOOL(y) -> if(y = true)
                                                                                 then processor restOfCL ((a::restOfStack)::stl) ((env)::etl)
                                                                                 else processor restOfCL ((b::restOfStack)::stl) ((env)::etl)
                                                                | _ -> processor restOfCL ((ERROR::a::b::NAME(c)::restOfStack)::stl) ((env)::etl))    
    | BIND::restOfCL, (NAME(a)::NAME(b)::restOfStack)::stl, ((env)::etl) -> (match look a ((env)::etl) with
                                                                          | Some INT(y) -> processor restOfCL ((UNIT::restOfStack)::stl) (((NAME(b),INT(y))::env)::etl)
                                                                          | Some STRING(y) -> processor restOfCL ((UNIT::restOfStack)::stl) (((NAME(b),STRING(y))::env)::etl)
                                                                          | Some BOOL(y) -> processor restOfCL ((UNIT::restOfStack)::stl) (((NAME(b),BOOL(y))::env)::etl)
                                                                          | Some UNIT -> processor restOfCL ((UNIT::restOfStack)::stl) (((NAME(b),UNIT)::env)::etl)
                                                                          | _ -> processor restOfCL ((ERROR::NAME(a)::NAME(b)::restOfStack)::stl) ((env)::etl))    
    | BIND::restOfCL, (ERROR::NAME(b)::restOfStack)::stl, ((env)::etl) -> processor restOfCL ((ERROR::ERROR::NAME(b)::restOfStack)::stl) ((env)::etl)    
    | BIND::restOfCL, (a::NAME(b)::restOfStack)::stl, ((env)::etl) -> processor restOfCL ((UNIT::restOfStack)::stl) (((NAME(b),a)::env)::etl)
    | LET::restOfCL, restOfStack,env -> processor restOfCL ([]::restOfStack) ([]::env) 
    | END::restOfCL, a::restOfStack, b::env ->(match (a, restOfStack) with
                                        | ([], restOfStack) -> processor restOfCL (restOfStack) env
                                        | (x::tl, a::restOfStack) ->  processor restOfCL ((x::a)::restOfStack) env
                                        | (_, _) -> processor restOfCL (restOfStack) env)
    | FUN("expr1 b")::restOfCL,((restOfStack)::stl), ((c::env)::etl) -> file_write "9 :unit: :unit:" ; stack
    | _::restOfCL, ((restOfStack)::stl), env -> processor restOfCL ((ERROR::restOfStack)::stl) env
    | [], _, _ -> stack
    | _, _, _ -> stack    
     in ignore (processor commandList [[]] [[]])
    
         ;;    
         interpreter ("input1.txt", "output1.txt")       