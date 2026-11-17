import pickle
import os

# Create a file if it does not exist
fp = open(r'D:/record.txt','ab+')
fp.close()

while True:
    os.system('cls')
    print('1. Add Record')
    print('2. Display Records')
    print('3. Search Record')
    print('4. Modify Record')
    print('5. Delete Record')
    print('0. Exit')
    choice = int(input('Enter Your Choice : '))

    # Add Record
    if choice == 1:
        with open(r'D:\record.txt', 'ab+') as fileobj:    # open file for adding records

            name = input('Enter Name: ')
            age = int(input('Enter Age: '))
            salary = float(input('Enter Salary :'))
            data = [name, age, salary]      # create a list of data
            pickle.dump(data, fileobj)      # write data to binary file


    # Display Records
    elif choice == 2:
        with open(r'D:\record.txt', 'rb') as fileobj:    # open file for displaying records

            f=0
            print('\nNAME\t\t\tAGE\tSALARY')    # print the heading
            while True:
                try:
                    # load individual record from the file using the load() method
                    data = pickle.load(fileobj)

                    if len(data) !=0:
                        f=1
                        print('%s\t\t\t%d\t%.2f' %(data[0], data[1], data[2]))

                except EOFError:
                    break

            if f==0:
                print('\nRecord does not exist')
            input('\nPress enter to continue...')     # Pause the loop so that the user can see the message


    # Search Record
    elif choice == 3:
        with open(r'D:\record.txt', 'rb') as fileobj:    # open file for searching records

            f=0
            nm = input('Enter name to search: ')
            print('\nNAME\t\t\tAGE\tSALARY')    # print the heading
            while True:
                try:
                    # load individual record from the file using the load() method
                    data = pickle.load(fileobj)

                    if nm == data[0]:
                        f=1
                        print('%s\t\t\t%d\t%.2f' %(data[0], data[1], data[2]))
                        break

                except EOFError:
                    break

            if f==0:
                print('\nRecord does not exist')
            input('\nPress enter to continue...')     # Pause the loop so that the user can see the message


    # Modify Record
    elif choice == 4:

        records = []
        f=0
        nm = input('Enter name to modify record: ')
        with open(r'D:\record.txt', 'rb') as fileobj:    # open file for reading records
            while True:
                try:
                    # load individual record from the file using the load() method
                    data = pickle.load(fileobj)
                    if data[0] == nm:
                        data[0] = input('New Name: ')
                        data[1] = int(input('New Age: '))
                        data[2] = float(input('New Salary: '))
                        f=1

                    # append data to the list (records)
                    records.append(data)

                except EOFError:
                    break

        if f==0:
            print('\nRecord does not exist')
        else:

            # write all records in the file
            with open(r'D:\record.txt', 'wb') as fileobj:    # open file for writing records
                for x in records:
                    pickle.dump(x, fileobj)

        input('\nPress enter to continue...')     # Pause the loop so that the user can see the message


    # Delete Record
    elif choice == 5:

        records = []
        with open(r'D:\record.txt', 'rb') as fileobj:    # open file for reading records
            while True:
                try:
                    # load individual record from the file using the load() method
                    data = pickle.load(fileobj)

                    # append data to the list (records)
                    records.append(data)

                except EOFError:
                    break

        # write all records in the file
        f=0
        nm = input('Enter name to delete record: ')
        with open(r'D:\record.txt', 'wb') as fileobj:    # open file for writing records
            for x in records:
                if x[0] == nm:
                    f=1
                else:
                    pickle.dump(x, fileobj)

        if f==0:
            print('\nRecord does not exist')
        else:
            print('\nRecord deleted successfully')
        input('\nPress enter to continue...')     # Pause the loop so that the user can see the message

    elif choice == 0:
        exit(0)
