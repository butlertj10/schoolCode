let welcome = "Welcome to the Oakland, California Municipal Library (OCaML)"

(* These types are defined for you. You should not modify them *)
type catalog_item = Book of string * string * string | Movie of string * int * string
                  | CD of string * string * string | Computer
type checkout_entry = Item of catalog_item | New of checkout_entry | Extend of checkout_entry
                    | Pair of checkout_entry * checkout_entry
type cart = CartEntry of checkout_entry * int option * cart | Empty 

(* Examples *)
(* These are some examples of checkout_item. You should test locally with these before submitting *)
let i0 = Book ("Types and Programming Languages", "Benjamin Pierce", "The MIT Press")
let i1 = Movie ("The Imitation Game", 2014, "Morten Tyldum")
let i2 = Computer

(* These are some examples of checkout_entry. You should test locally with these before submitting *)
let e0 = Item i0
let e1 = Item i1
let e2 = Item i2

let e3 = Item (CD ("Songs to Test By", "Aperture Science Psychoacoustic Laboratories", "73:39"))
let e4 = New (Item (Book ("UNIX: A History and a Memoir", "Brian W. Kernighan", "Independently published")))

let e5 = Pair (
    Item (Movie ("WarGames", 1983, "John Badham")),
    Item (Movie ("Sneakers", 1992, "Phil Alden Robinson"))
)

let e6 = Pair (
    Pair (
        Item (Book ("The Unix Programming Environment", "Brian W. Kernighan and Rob Pike", "Prentice-Hall")), 
        New (Item (Book ("The C Programming Language", "Brian Kernighan and Dennis Ritchie", "Pearson")))
    ),
    Extend (Item (Book ("The AWK Programming Language", "Alfred V. Aho, Brian W. Kernighan, and Peter J. Weinberger",
                        "Pearson")))
)

(* This is an exmaple of a cart. You should test locally with it before submitting *)
let checked_out = CartEntry (e1, Some 2,
                     CartEntry (e2, None,
                       CartEntry (e4, Some 1,
                         CartEntry (e5, Some 2, Empty))))

(* The following functions you must implement *)

(* Display item as string *)
let string_of_item (i : catalog_item) : string = 
	match i with
	| Book (book_title, book_author, book_publisher) -> (book_title ^ " by " ^ book_author ^ " (" ^ book_publisher ^ ")")
	| Movie (movie_title, movie_date, movie_director) -> (movie_title ^ " (" ^ string_of_int movie_date ^ ") " ^ "by " ^ movie_director)
	| CD (cd_album, cd_artist, cd_length) -> (cd_album ^ " by " ^ cd_artist ^ " (" ^ cd_length ^ ")")
	| Computer -> "Public Computer" 

(* Display entry as string *)
let rec string_of_entry (e : checkout_entry) : string = 
	match e with
	| Item (item) -> string_of_item(item)
	| New (new_item) -> "(NEW) " ^ string_of_entry(new_item)
	| Pair (pair_1 , pair_2) -> string_of_entry(pair_1) ^ " and " ^ string_of_entry(pair_2) 
	| _ -> " "
	
(* Return the daily fine for an overdue item *)
let rec daily_fine (entry: checkout_entry) : float = 
	match entry with 
	| Item (item_fee) -> (match item_fee with
						 | Book(a, b, c) -> 0.25
						 | Movie(a, b, c) -> 0.5
						 | CD(a, b, c) -> 0.5
						 | Computer -> 0.0)
	| New (new_item_fee) -> daily_fine(new_item_fee) *. 2.0
	| Extend (extented_item_fee) -> daily_fine(extented_item_fee) *. 3.0
	| Pair (pair_1_fee , pair_2_fee) -> daily_fine(pair_1_fee) +. daily_fine(pair_2_fee)

(* Given a list of items and days overdue, compute the total fine *)
let rec total_fine (l : cart) : float = 
	match l with
	| Empty -> 0.0  
	| CartEntry (a, b, c) -> (match b with 
							 | None -> 0.0
							 | Some x -> (((float_of_int x) *. daily_fine(a)) +. (total_fine(c))))

(* 
(* String of items *)
let a = string_of_item(i0)
let b = string_of_item(i1)
let c = string_of_item(i2)

(* String of entries *)
let d = string_of_entry(e0)
let e = string_of_entry(e1)
let f = string_of_entry(e2)
let g = string_of_entry(e3)
let h = string_of_entry(e4)
let i = string_of_entry(e5)
let j = string_of_entry(e6)

(* Daily Fines *)
let k = daily_fine(e0)
let l = daily_fine(e1)
let m = daily_fine(e2)
let n = daily_fine(e3)
let o = daily_fine(e4)
let p = daily_fine(e5)
let q = daily_fine(e6) 

(* Total Fine *)
 let r = total_fine(checked_out)  *)

