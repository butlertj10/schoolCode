########### Lab2.asm ###############
#         Trevor Butler            #
#		  Input/Output			   # 
#			2/28/19                #
#          CSC - 211               #
#	Prompts user to enter two	   #
#	numbers to add, adds them	   #
#	then displays the equation	   #
#	with the two numbers input	   #
#		and the final answer	   #
####################################

        .text
        .globl main
main:
        # Print out prompt 
        la $a0,prompt        # load beginning address of string into $a0 register 
        li $v0,4             # load call code to print a string into register $v0
        syscall              # system call to display "Enter first number:"

        # Get the first number from User
        li $v0,5             # load call code to read an intger from keyboard
        syscall              # system call to read input and store in $v0
		
		move $t0,$v0		 # moves int from $vo register to $t0 register
		
		# Print out prompt 
        la $a0,prompt2       # load beginning address of string into $a0 register 
        li $v0,4             # load call code to print a string into register $v0
        syscall              # system call to display "Enter second number:"
		
		# Get the second number from User
        li $v0,5             # load call code to read an integer from keyboard
        syscall				 # system call to read integer and store in $v0
        move $t1,$v0

        # Adds two numbers together and stores ans in $t2
        add $t2,$t1,$t0    	 # $t0 + $t1 = $t2 
		
		# Display first number
        move $a0,$t0         # move first number to $a0 for display
        li $v0,1             # load call code to print an int     
        syscall              # system call to display first number
		
		# Display addition opp
        la $a0, ans1         # load beginning address of display message into $a0 register
        li $v0,4             # load call code to print a string  
        syscall              # system call to display " + "
        
		# Display second number
        move $a0,$t1         # moves second number to $a0 for display
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
         prompt: .asciiz "Enter first number: "       # Prompt for first number
		 prompt2: .asciiz "Enter second number: "	  # Prompt for second number
         ans1:   .asciiz "  +  "					  # Output + opp
		 ans2:   .asciiz "  =  "					  # Output = opp
         endl:   .asciiz "\n"                         # New line character
 