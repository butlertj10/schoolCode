type stackValue = BOOL of bool | INT of int | ERROR | STRING of string | NAME of string | UNIT
type command  = ADD | SUB | MUL | DIV | REM | NEG | SWAP | TOSTRING | PRINTLN | POP | QUIT | PUSH of stackValue 

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
			  
  let num_ls = ['1'; '2'; '3'; '4'; '5'; '6'; '7'; '8'; '9' ; '-'] in

(***** Start of Functions ******)

  (* Checks if stackValue is a name *)
  let rec check_name str ch_list =
    match ch_list with
    | [] ->  "false"
    | c::rest_chs -> if String.contains str c
                     then "true"
                     else check_name str rest_chs in
	
  (* Checks if stackValue is a number *)
  let rec check_num str num_list =
    match num_list with
    | [] -> "false"
    | c::rest_chs -> if String.contains str c
                     then "true"
                     else check_num str rest_chs in
  
  (* Takes a string and matches a stack value *)
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
						 then INT(int_of_string s)
						 else raise (NoString s) in

  (* Takes a string a matches to command *)  					 
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
	  | _ -> let subStr = String.sub s 0 4 in 
	              if subStr = "push"
				  then let subStr2 = (String.sub s 5 (String.length s - 5))in PUSH(stringToStackValue subStr2)
				  else raise (NoStr s) in
  
  (* Takes a stack value and matches to string *)
  let stackValuetoString (sv : stackValue) : string =
	match sv with
	| BOOL(tf) -> ":" ^ string_of_bool tf ^ ":"
	| INT(num) -> string_of_int num
	| ERROR -> ":error:"
	| NAME(name) -> name
	| STRING(str) -> str
	| UNIT -> ":unit:"
  in

  let commandList = List.map stringToCommand strList
  in
  
  (* Processes the stack with command list  *)
  let rec processor cl stack = 
    match (cl, stack) with 
	| [], _ -> stack
	| ADD::restOfCL, INT(a)::INT(b)::restOfStack -> processor restOfCL (INT(b+a)::restOfStack)	
	| SUB::restOfCL, INT(a)::INT(b)::restOfStack -> processor restOfCL (INT(b-a)::restOfStack)
	| MUL::restOfCL, INT(a)::INT(b)::restOfStack -> processor restOfCL (INT(b*a)::restOfStack)
	| DIV::restOfCL, INT(0)::INT(b)::restOfStack -> processor restOfCL (ERROR::stack)
	| DIV::restOfCL, INT(a)::INT(b)::restOfStack -> processor restOfCL (INT(b/a)::restOfStack)
	| REM::restOfCL, INT(0)::INT(b)::restOfStack -> processor restOfCL (ERROR::stack)
	| REM::restOfCL, INT(a)::INT(b)::restOfStack -> processor restOfCL (INT(b mod a)::restOfStack)
	| NEG::restOfCL, INT(a)::restOfStack -> processor restOfCL (INT(-a)::restOfStack)  
	| SWAP::restOfCL, a::b::restOfStack -> processor restOfCL (b::a::restOfStack)
	| POP::restOfCL, a::restOfStack -> processor restOfCL restOfStack  
	| TOSTRING::restOfCL, a::restOfStack -> processor restOfCL (STRING(stackValuetoString a)::restOfStack)
	| PRINTLN::restOfCL, STRING(a)::restOfStack -> file_write a ; processor restOfCL restOfStack
	| PUSH(stackVal)::restOfCL, stack -> processor restOfCL (stackVal::stack)
	| QUIT::restOfCL, restOfStack -> stack
	| _::restOfCL, stack -> processor restOfCL (ERROR::stack)
	 in ignore (processor commandList [])
	
	   (* ;; 
	      interpreter ("input10.txt", "output10.txt") *)   