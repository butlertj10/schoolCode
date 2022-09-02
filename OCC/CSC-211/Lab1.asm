########### FtoC.asm ###############
#         Trevor Butler            #
#		  Input/Output			   # 
#			2/28/19                #
#          CSC - 211               #
#	Prompts user to enter their	   #
#	name, then their birth year.   #
#	The program will calcualte	   #
#	their age by subracting the	   #
#	current year by their input    #
#	birth year and display their   #
#			current age			   #
####################################

        .text
        .globl main
main:
        # Print out prompt 
        la $a0,prompt        # load beginning address of string into $a0 register 
        li $v0,4             # load call code to print a string into register $v0
        syscall              # system call to display "Please enter your name: "

        # Get the name from user
        li $v0,8			 # take in input
        li $a1, 20			 # allot the byte space for string
        move $t0,$a0		 # save string to $t0
        syscall
		
		# Print out prompt to get age 
        la $a0,prompt2       # load beginning address of string into $a0 register 
        li $v0,4             # load call code to print a string into register $v0
        syscall              # system call to display "Enter the year you were born: "
		
		# Get the birth year from user
        li $v0,5             # load call code to read an integer from keyboard
        syscall				 # system call to read integer and store in $v0
        move $t1,$v0

		# Sets curret year to register
		li $s0, 2019
		syscall

        # Adds two numbers together and stores ans in $t2
        sub $t2,$t1,$s0    	 # $s0 - $t1 = $t2 
		
		# Display first number
        move $a0,$t0         # move first number to $a0 for display
        li $v0,1             # load call code to print an int     
        syscall              # system call to display first number
		
		# Display addition opp
        la $a0, ans1         # load beginning address of display message into $a0 register
        li $v0,4             # load call code to print a string  
        syscall              # system call to display " + "
        
		# Display second number
        move $a0, $t1        # moves second number to $a0 for display
        li  $v0,1            # load call code to print an int      
        syscall              # system call to display second number
		
		# Display equals opp
        la $a0, ans2         # load beginning address of display into $a0 register
        li $v0,4             # load call code to print a string  
        syscall              # system call to display " = "
		
        # Display result
        move $a0,$t2         # move answer from $t2 to $a0 for display
        li  $v0,1            # load call code to print the result     
        syscall              # system call to display the result

        # Move to next line        
        la $a0,endl          # returns new line
        li $v0,4             # load call code to print a string (new line is a string)
        syscall              # system call to move to next line

        li $v0,10            # load call code to End Program
        syscall              # system call to end program

        #Data Section
         .data
         prompt: .asciiz "Please enter your name: "			# Prompt for name
		 prompt2: .asciiz "Enter the year you were born: "	# Prompt for birth year
         ans1:   .asciiz "  +  "   #Output message
		 ans2:   .asciiz "  =  "   #Output message
         endl:   .asciiz "\n"                                  #New line character
 