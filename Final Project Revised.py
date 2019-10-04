def path_one(dead):  # this function outlines the logic of the program if the player decides to go towards the window
    dead = False
    while dead == False:
        choice_two_route_one = int(input("You decide to go make your way up to the window.\nAs you climb up, rocks "
                                         "fall and almost hit you, but you manage to avoid them.\nOn your way to "
                                         "the window, you notice a gap that you must cross.\nThere is a small "
                                         "opening allowing you to sidle against the wall to cross the gap,\nbut the"
                                         " fall is quite steep. However, you notice some foot holes that will allow you"
                                         " to climb up to the window instead of going around.\nWhich way do you "
                                         "choose? Enter 1 to cross the gap, or enter 2 to climb up to the window: "))
        if choice_two_route_one == 1:  # if the user chooses to cross the gap
            print("You decide to try and sidle across the gap.\nHowever, about halfway through you are struck by a "
                  "falling rock, and you die.")
            dead = True
            return dead
        elif choice_two_route_one == 2:
            choice_three_route_one = int(input(" You decide to climb the foot holes, and you make it to the window.\n"
                                               "However, as soon as you enter, a guard spots you.\n'Freeze! Hands "
                                               "up or I'll shoot!'the guard shouts.\nYou raise your hands "
                                               "reluctantly. This one will be hard to get out of.\nDo you try and "
                                               "negotiate with him, or do you surrender and let him throw you in "
                                               "jail?"))
            if choice_three_route_one == 1:
                print("You decide to try and negotiate with the guard.\n'Look, we both know why I'm here. And, we "
                      "both know how much that artifact is worth.\nI'm just trying to make a living here. I have a"
                      " kid who needs to eat, whether or not you like my methods is a different story.\nHowever, "
                      "if you just turn  a blind eye to this, I'll make it worth your while.' you say.\n'I "
                      "understand, but I'm just doing my job here.\nMy boss orders any intruders to be killed on "
                      "sight, so I'm already doing you a favor.\nBut, not that favor is up.' the guard says.\n"
                      "The guard pulls the trigger, and you are shot dead.")
                dead = True
                return dead
            elif choice_three_route_one == 2:
                print("You decide to comply. 'Fine. You caught me.' you reluctantly say.\nThe guard locks you up in"
                      " jail and you are sentenced to life in prison for breaking and entering.\nIts unfair, but a "
                      "thief's life isn't fair. Your journey is over.")
                dead = True
                return dead
            else:
                print("Please enter a valid input.")
        else:
            print("Please enter a valid input.")


def path_two(dead, artifact):
    dead = False
    while dead == False:
        choice_two_route_two = int(input("You enter the cellar and drop down to the ground.\nYou notice a guard "
                                         "patrolling the hallway, but you are able to hide behind an old statue.\n"
                                         " Do you shoot the guard, or try to take him out stealthily?\n Enter 1 to "
                                         "shoot the guard, or enter 2 to take him out stealthily: "))
        if choice_two_route_two == 1:
            print("You decide to shoot the guard, but your gunshot is louder than you expected.\nAfter only a few "
                  "seconds, the alarm starts to go off.\n'Someone is here! I want the intruder dead on sight!' a "
                  "voice yells.\nYou begin sprinting down the cellar hallway in hopes to find the artifact,\n"
                  "but you are shot dead by a guard perched on a higher level.")
            dead = True
            artifact = False
            return dead, artifact
        elif choice_two_route_two == 2:
            choice_three_route_two = int(input("You decide to sneak up on the guard.\nYou silently take him down, "
                                               "along with the other guards on the floor.\nYou end up in a room "
                                               "with a golden door.\n'This must be where the artifact is,' you "
                                               "think to yourself.\nYou notice two odd things about the room.\n"
                                               "For one, there is a snake statue with a button between it's fangs.\n"
                                               "You also notice a keypad on the other side of the room.\nYou found"
                                               " a notebook with numbers written down in it, which may have some "
                                               "meaning.\n Which do you choose to examine?"))
            if choice_three_route_two == 1:
                print("You decide to press the button. '\n' After waiting for awhile, the room blows up.\n"
                      "The button triggered a trap, and you died.")
                dead = True
                artifact = False
                return dead, artifact
            elif choice_three_route_two == 2:
                print("You look at the numbers in the notebook, and enter them into the keypad.\n"
                      "60743. Click! The door opens, and you steal the artifact.\nYou make your way out of the "
                      "palace, and pawn off the artifact for money to help support your family.\nMission "
                      "accomplished!")
                artifact = True
                dead = False
                return artifact, dead
            else:
                print("Please enter a valid input option.")
        else:
            print("Please enter a valid input option.")


def main():
    # gives user the basic story, acts as a title screen of sorts
    begin_game = int(input("You are an adventurer named Drake.\nYou are trying to infiltrate a palace and steal the"
                           " treasure, an artifact of ancient origins.\nAlong the way, there will many choices you "
                           "must make.\nEnter either 1 or 2 to go down the corresponding path.\nBe careful "
                           "though, some paths may send you back to the start, and others may kill you.\nIf you "
                           "successfully infiltrate the palace and secure the artifact, you win.\nWould you like "
                           "to play? Enter 1 to start and 2 to quit."))
    while begin_game == 1:  # if the user enters 1 the game begins, and if they enter 2 the program ends
        player_dead = False  # flag to check if the player is dead
        player_wins = False  # flag to check if the player found the artifact or not
        # first choice the player makes, determines what path the route will go on
        choice_one = int(input("As you stand in front of the palace, you notice security guards up front.\nIts "
                               "obvious they won't just let you in.\nAs such, another way must be found.\nYou"
                               " notice an open window high up to your left.\nOn the right you notice a cellar "
                               "that is unlocked.\nWhich way do you go? Enter 1 to climb up towards the window, or "
                               "enter 2 to investigate the cellar door: "))
        if choice_one == 1:  # player makes their way towards the window, putting them on the first path
            player_dead = path_one(player_dead)  # calls the path one function and saves the value of player_dead to
            # either true or false
            if player_dead:  # runs if dead = True
                begin_game = input("Unfortunately, you were not able to steal the artifact and you died in the process."
                                   "\nWould you like to to play again? Enter 1 to play again and enter 2 to end "
                                   "the game.")
                if begin_game == 1:  # continues the loop and allows the player to play again
                    main()
                elif begin_game == 2:  # breaks out of the loop and ends the game
                    print("Thank you for playing.")
                    break
        if choice_one == 2:
            player_dead, player_wins = path_two(player_dead, player_wins)  # calls the path two function and saves the
            # values of player_dead and player_wins to either true or false
            if player_dead == True:
                begin_game = input("Unfortunately, you were not able to steal the artifact and you died in the process."
                                   "\nWould you like to to play again? Enter 1 to play again and enter 2 to end "
                                   "the game.")
                if begin_game == 1:
                    main()
                elif begin_game == 2:
                    print("Thank you for playing.")
                    break
            if player_wins == True:
                begin_game = input("You successfully stole the artifact! Would you like to play again?\nEnter 1 to "
                                   "play again and enter 2 to end the game.")
                if begin_game == 1:
                    main()
                elif begin_game == 2:
                    print("Thank you for playing.")
                    break


main()
