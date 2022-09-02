########### Age.asm ###################
#          Trevor Butler              #
#	   FahrenheitToCelsius            # 
#			2/28/19                   #
#          CSC - 211                  #
#	This program will get the name	  #
#	an age from user and displays     #
#	their birthyear along with a 	  #
#			greeting				  #
#######################################


        .text
        .globl main
main:
        #Print out prompt 
        la $a0,prompt        # load beginning address into $a0 register 
        li $v0,4             # load call code to print  $v0
        syscall              # system call to display 

        #Get from User
        li $v0,8             # load call code to read a String from keyboard
        syscall              # system call to read String and store in $f0
		
		move $t1,$v0
		
		#Print out prompt 
        la $a0,prompt2       # load beginning address of string into $a0 register 
        li $v0,4             # load call code to print a string into register $v0
        syscall              # system call to display 
		
		#Get from User
        li $v0,5             # load call code to read a float from keyboard
        syscall              # system call to read float and store in $f0
		
		#Initialize int values for conversion
        li $t1, 2019
		
        #Calculate
        sub $t2,$t1,$v0    	
		
		#Display output message
        la $a0, ans1         # load beginning address of display message into $a0 register
        li $v0,4             # load call code to print
        syscall              # system call to display
		
		#Display 
        move $v0,$t1         # move from f2 -> f12 for display
        li  $v0,4            # load call code to print       
        syscall              # system call to display 
		
		#Move to next line        
        la $a0,endl          # display cr/lf
        li $v0,4             # load call code to print a string
        syscall              # system call to move to next line
		
		#Display output message
        la $a0, ans2         # load beginning address of display message into $a0 register
        li $v0,4             # load call code to print a string  
        syscall              # system call to display
        
		#Move to next line        
        la $a0,endl          # display cr/lf
        li $v0,4             # load call code to print a string (new line is a string)
        syscall              # system call to move to next line
		
		#Display output message
        la $a0, ans3         # load beginning address of display message into $a0 register
        li $v0,4             # load call code to print    
        syscall              # system call to display 
		
        #Display 
        move $a0,$t2         # move Fahrenheit  from f2 -> f12 for display
        li  $v0,1            # load call code to print a float     
        syscall              # system call to display 

        #Move to next line        
        la $a0,endl          # display cr/lf
        li $v0,4             # load call code to print a string (new line is a string)
        syscall              # system call to move to next line

        li $v0,10            # load call code to End Program
        syscall              # system call to end program

        #Data Section
         .data
         prompt: .asciiz "Enter Your Name: "    
		 prompt2: .asciiz "Enter Your Age: "
         ans1:   .asciiz "Hello "   			#Output message
		 ans2:   .asciiz "Welcome to CSC 211 "  #Output message
		 ans3:   .asciiz "You were born in "    #Output message
         endl:   .asciiz "\n"                   #New line character
 
#############################
#	Enter Your Name: Trevor	#
#	Enter Your Age: 19		#
#	Hello Trevor			#
#	Welcome to CSC 211 		#
#	You were born in 2000	#
#############################