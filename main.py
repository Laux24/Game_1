"--disable=C0111"
import random
#Health
BLUE=70
GREEN=50
RED=60
YELLOW=80
YELLOWS=0

LENEMY=100
MENEMY=150
HENEMY=200
BOSS=250

#Damage
BLUED=20
GREEND=5
REDD=10
YELLOWD=15

LENEMYD=10
MENEMYD=15
HENEMYD=20
BOSSD=25

#Magic
BLUEM=1.5
GREENM=10
REDM=15
YELLOWM=5

LENEMYM="Water"
MENEMYM="Wind"
HENEMYM="Lightning"
BOSSM="Fire"

#Attributes
BLUEA="Water"
GREENA="Wind"
REDA="Fire"
YELLOWA="Lightning"


PLAYERSA=[BLUEA,GREENA,REDA,YELLOWA]
NAMES=["Blue","Green","Red","Yellow"]
ENMYL=[LENEMY, MENEMY, HENEMY]
TYPES=["Fire","Water","Lightning","Wind"]


def end():
    print("\nGAME OVER")
    while True:
        PLAYERS=PLAYERSA

def type(target, damage, attribute):
    if target=="Fire":
        if attribute=="Water":
            return(damage*2)
        elif attribute=="Wind":
            return(damage//2)
        else:
            return(damage)
    elif target=="Water":
        if attribute=="Fire":
            return(damage//2)
        elif attribute=="Lightning":
            return(damage*2)
        else:
            return(damage)
    elif target=="Lightning":
        if attribute=="Water":
            return(damage//2)
        elif attribute=="Wind":
            return(damage*2)
        else:
            return(damage)
    elif target=="Wind":
        if attribute=="Fire":
            return(damage*2)
        elif attribute=="Lightning":
            return(damage//2)
        else:
            return(damage)





def action(num):
    global CENMYH, CENMYM, CENMYD, BLUE, GREEN, RED, YELLOW, BLUED, YELLOWS, MA
    while True:
        act=input("What would you like to do? (if you don't know the commands type: help): ")
        if act=="help":
            print("\n!ATTENTION!: ALL COMMANDS MUST BE LOWERCASE")
            print("attack or a: attack the enemy with your character's damage")
            print("magic or m: use your unique skill")
            print("stats: show the Party's health")
            print("skip or s: skip turn")
            print("d: commit dieicide\n")
        elif act=="skip" or act=="s":
            return(False)
        elif act=="d":
            BLUE=0
            GREEN=0
            RED=0
            YELLOW=0
            return(False)
        elif act=="stats":
            print("Blue's health:",BLUE)
            print("Green's health:",GREEN)
            print("Red's health:",RED)
            print("Yellow's health:",YELLOW)
        elif act=="attack" or act=="a":
            if num==1:
                CENMYH-=BLUED
                print("You decided to attack dealing",BLUED,"damage, which leaves the opponent at",CENMYH,"health")
            elif num==2:
                CENMYH-=GREEND
                print("You decided to attack dealing",GREEND,"damage, which leaves the opponent at",CENMYH,"health")
            elif num==3:
                CENMYH-=REDD
                print("You decided to attack dealing",REDD,"damage, which leaves the opponent at",CENMYH,"health")
            elif num==4:
                CENMYH-=YELLOWD
                print("You decided to attack dealing",YELLOWD,"damage, which leaves the opponent at",CENMYH,"health")
            return (False)
        elif act=="magic" or act=="m":
            if num==1:
                BLUED**=BLUEM
                MA+=3
                print("You used your magic which increased your attack for the next three turns")
            elif num==2:
                while True:
                    target=input("Who would you like to heal? ")
                    if target=="blue":
                        BLUE+=GREENM
                        if BLUE>70:
                            BLUE=70
                        print("You used your magic and decided to heal Blue, which brings their health up to",BLUE)
                        return(False)
                    if target=="green":
                        GREEN+=GREENM
                        if GREEN>50:
                            GREEN=50
                        print("You used your magic on yourself, which brought your health up to",GREEN)
                        return(False)
                    if target=="red":
                        RED+=GREENM
                        if RED>60:
                            RED=60
                        print("You used your magic and decided to heal Red, which brings their health up to",RED)
                        return(False)
                    if target=="yellow":
                        YELLOW+=GREENM
                        if YELLOW>80:
                            YELLOW=80+YELLOWS
                        print("You used your magic and decided to heal Yellow, which brings their health up to",YELLOW)
                        return(False)
            elif num==3:
                TYP=random.choice(TYPES)
                DMG=type(CENMYM,REDM,TYP)
                CENMYH-=DMG
                print("You used your magic to launch a",TYP,"attack at the opponent, dealing ",DMG,"damage, and leaving the opponent at",CENMYH,"health")
            elif num==4:
                YELLOWS+=YELLOWM
                YELLOW+=YELLOWM
                print("You used your magic which increased your health to",YELLOW)
            return (False)
        else:
            print("That's not a move, try again")

NUM=0
MA=0
def turn():
    global NUM, MA, BLUED, PLAYERS
    NUM+=1
    if NUM==1 and BLUE>0:
        print("\nIt's Blue's turn. They have", BLUE,"health,",BLUED,"damage, and they're a",BLUEA,"type.")
        action(1)
        if MA>0:
            MA-=1
        else:
            BLUED=20
    if NUM==2 and GREEN>0:
        print("\nIt's Green's turn. They have", GREEN,"health,",GREEND,"damage, and they're a",GREENA,"type.")
        action(2)
    if NUM==3 and RED>0:
        print("\nIt's Red's turn. They have", RED,"health,",REDD,"damage, and they're a",REDA,"type.")
        action(3)
    if NUM==4 and YELLOW>0:
        print("\nIt's Yellow's turn. They have", YELLOW,"health,",YELLOWD,"damage, and they're a",YELLOWA,"type.")
        action(4)

def ebattle(CENMY):
    global CENMYH, CENMYD, CENMYM, NUM, BLUE, GREEN, RED, YELLOW, PLAYERS, YELLOWS
    if CENMY==LENEMY:
        CENMYD=LENEMYD
        CENMYM=LENEMYM
        CENMYH=LENEMY
    elif CENMY==MENEMY:
        CENMYD=MENEMYD
        CENMYM=MENEMYM
        CENMYH=MENEMY
    elif CENMY==HENEMY:
        CENMYD=HENEMYD
        CENMYM=HENEMYM
        CENMYH=HENEMY
    elif CENMY==BOSS:
        CENMYD=BOSSD
        CENMYM=BOSSM
        CENMYH=BOSS

    ENMYML=[CENMYD, CENMYM]
    if CENMY==BOSS:
        print("\nIt's the Boss, it has a whopping",BOSS,"health,",BOSSD,"damage, and it's a",BOSSM,"type.")
    else:
        print("\nYou've encountered an enemy with",CENMY,"health,",CENMYD,"damage, and it's a",CENMYM,"type.")
    NUM=0
    while CENMYH>0:
        turn()
        PLAYERS=[BLUE,GREEN,RED,YELLOW]
        DEAD=[]
        PNUM=-1
        if BLUE<1:
            DEAD.append(BLUE)
        else:
            PNUM+=1
            CNUM=0
            for i in (DEAD):
                if i==BLUE:
                    CNUM=1
            if CNUM==1:
                DEAD.remove(BLUE)
        if GREEN<1:
            DEAD.append(GREEN)
        else:
            PNUM+=1
            CNUM=0
            for i in (DEAD):
                if i==GREEN:
                    CNUM=1
            if CNUM==1:
                DEAD.remove(GREEN)
        if RED<1:
            DEAD.append(RED)
        else:
            PNUM+=1
            CNUM=0
            for i in (DEAD):
                if i==RED:
                    CNUM=1
            if CNUM==1:
                DEAD.remove(RED)
        if YELLOW<1:
            DEAD.append(YELLOW)
        else:
            PNUM+=1
            CNUM=0
            for i in (DEAD):
                if i==YELLOW:
                    CNUM=1
            if CNUM==1:
                DEAD.remove(YELLOW)
        if len(DEAD)==4:
            end()
            

        if CENMYH>0 and NUM==4:
            move=random.choice(ENMYML)
            DNUM=0
            while DNUM!=2:
                DNUM=0
                enum=random.randint(0,3)
                tgrt=PLAYERS[enum]
                name=NAMES[enum]
                for i in DEAD:
                    if tgrt==i:
                        DNUM=1
                if DNUM==0:
                    DNUM=2
                

            if move==CENMYD:
                tgrt-=CENMYD
                if enum==0:
                    BLUE-=CENMYD
                elif enum==1:
                    GREEN-=CENMYD
                elif enum==2:
                    RED-=CENMYD
                elif enum==3:
                    YELLOW-=CENMYD
                    YELLOWS=YELLOW-80
                    if YELLOWS<0:
                        YELLOWS=0
                if CENMY==BOSS:
                    print("\nThe Boss threw an attack at",name,"dealing",BOSSD,"damage, leaving them at",tgrt,"health")
                else:
                    print("\nThe enemy decided to attack",name,"dealing",CENMYD,"damage, leaving them at",tgrt,"health")
            elif move==CENMYM:
                DMG=type(random.choice(PLAYERSA),10,CENMYM)
                tgrt-=DMG
                if enum==0:
                    BLUE-=DMG
                elif enum==1:
                    GREEN-=DMG
                elif enum==2:
                    RED-=DMG
                elif enum==3:
                    YELLOW-=DMG
                    YELLOWS=YELLOW-80
                    if YELLOWS<0:
                        YELLOWS=0
                if CENMY==BOSS:
                    print("\nThe Boss used magic on",name,"dealing",DMG,"leaving them at",tgrt,"health")
                else:
                    print("\nThe enemy decided to use magic on",name,"dealing",DMG,"damage leaving them at",tgrt,"health")
            NUM=0
    if CENMY==BOSS:
        input("\nYou've beaten the game, congragulations!")
    else:
        input("\nYou've defeated the Enemy! Ready for the next battle? ")



def game():
    for i in range(3):
        ebattle(random.choice(ENMYL))
    ebattle(BOSS)
    end()

game()
    