

.data
prompt1: .asciiz "Enter the first number please: "
prompt2: .asciiz "Enter the second number please: "
result: .asciiz "The result is: "
addop: .asciiz " + "
equalop: .asciiz " = "

.text
main:
    #t0 - to hold first number
    #t1 - to hold second number
    #t2 - used to hold the sum of t$1 and t$2

#Display First Prompt
	la $a0,prompt1       # load beginning address of string into $a0 register 
        li $v0,4             # load call code to print a string into register $v0
	syscall              # system call to display prompt to enter first number

	li $v0,6		# loads    
	syscall
    	
	mov.s $f1,$f0

#Display Second Prompt
	la $a0,prompt2       # load beginning address of string into $a0 register 
	li $v0,4             # load call code to print a string into register $v0
	syscall              # system call to display prompt to enter second number

	li $v0,6
	syscall		# loads    
	 
#Add two numbers and get results
	add.s $f2, $f0, $f1 
	li $v0, 1
	syscall

#first Number
	la $a0, t0
	li $v0, 4
	syscall
	
 #Add opp
    li $v0, 4
    la $a0, addop
    syscall
	
 #Second number
    li $v0, 4
    la $a0, t1
    syscall
	
 #Equal opp
    li $v0, 4
    la $a0, equalop
    syscall

 #compute the sum
	add $a0, $t1, $t0 
    li $v0, 1
    syscall

    li $v0, 10
    syscall 
	
 #print out sum of $t2
    li $v0, 4
    la $a0, t2
    syscall