########### Input Integer and Display it #############

.text
.globl main

main:

la $a0,prompt                   # load address of prompt into a0
li $v0,4                        # load call code number to display a string into v0
syscall                         # system call to print the prompt string

li $v0,5                        # load call code number to read an integer -> v0
syscall                         # system call to read the integer and store in v0

move $t0,$v0                    # move integer from v0 -> t0 for safe keeping

la $a0, output                  # load address of output message into a0
li $v0,4                        # load call code number to display a string into v0
syscall                         # system call to print the output string

move $a0,$t0                    # move integer from t0 -> a0 for display
li $v0,1                        # load call code number to display the integer into v0
syscall                         # system call to print the integer

la $a0,endl                     # load the new line character into a0
li $v0,4                        # load the call code number to display the string into v0
syscall                         # system call to print the new line character

li $v0,10                       # Exit
syscall

#####data section######

.data

prompt: .asciiz "Enter an Integer: "           #prompt for the integer
output: .asciiz "The Integer you entered is "  #output message
endl: .asciiz "\n"