import sys
from model import Person

def showAllView(list):
    print ('In our db we have %i users. Here they are:' % len(list))
    for item in list:
        print (item.name())
        
def startView():
    print ('MVC - the simplest example')
    sys.stdout.write('Do you want to see everyone in my db?[y/n]: ')
    sys.stdout.flush()

def endView():
    print ('Goodbye!')    
