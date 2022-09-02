################################################
#				#  Output  #			       #
#				############			       #
#				                               #	
#			Enter first number: 6			   #	
#			Enter second number: 3			   #
#			    6  +  3  =  9				   # 
#											   #	
#											   #
################################################
.data
promtMsg1: .asciiz "Enter a string "
promtMsg2: .asciiz "Enter a character "
count: .word 10
string: .space 50
character: .space 4
output: .asciiz "# of character found = "

main:
li $t0, 50 #end var for loop
li $t1, 0 #start var for loop
li $t2, 0 #number of occurences

la $a0, promtMsg1 #print 'enter string'
li $v0, 4
syscall


la $a0, string #input string
li $a1, 50
li $v0, 8
syscall

la $a0, promtMsg2 #print 'Enter char'
li $v0, 4
syscall

la $a0, character #input character
li $a1, 4
li $v0, 8
syscall

la $s0, character
lb $s1, ($s0)
la $t3, string
lb $a2, ($t3) #gets first char of string

loop:
beq $a2, $zero, end #once reach end of char array, prints result
beq $a2, $s1, something #if the char within string == comparing char
addi $t3, $t3, 1 #increment char array
lb $a2,($t3)
j loop

something:   
addi $t2, $t2, 1 #increments number of occurences of char
end:
la $a0, output
li $v0, 4
syscall

la $a0, character
li $v0, 11
syscall
