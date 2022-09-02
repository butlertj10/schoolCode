#Data declaration part
.data
birthYear: .asciiz "Enter your birth Year: "
currentYear: .asciiz "Enter current year: "
yourAge: .asciiz "Your age is "
Error: .asciiz "Current year should not be less than birth year!!!\nEnter again\n"

#main Program
.text
main:

#Prompt user to enter birth year
la $a0,birthYear                        #address of the birth year prompt
li $v0,4                                #String display system call
syscall                                 #Print string
li $v0,5                                #Read year from keyboard system call
syscall                                 #Get integer in v0
move $s0,$v0                            #store birth year in s0

#Prompt user to enter current year
la $a0,currentYear                      #address of the current year prompt
li $v0,4                                #String display system call
syscall                                 #Print string

li $v0,5                                #Read year from keyboard system call
syscall                                 #Get integer in v0
move $s1,$v0                            #store current year in s1

#check years are proper
blt $s1,$s0,error                       #Year should not be negative check
sub $s1,$s1,$s0                         #Year difference for age

#Result prompt
la $a0,yourAge                          #address of the age prompt
li $v0,4                                #String display system call
syscall                                 #Print string

move $a0,$s1                            #Print age
li $v0,1                                #display integer system call
syscall                                 #display

#end of the program
Exit:
li $v0,10                               #program ending system call
syscall                                 #End

#Display error message
error:
la $a0,Error                            #address of the Error prompt
li $v0,4                                #String display system call
syscall                                 #Print string
j main                                  #go to main