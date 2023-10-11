Specifications for version 1:

    The project will have a class called Party.

    All properties will be private and accessible via get/set methods.
    The type property indicates the type of party: children's, birthday, costumes, etc.
    The snacks property contains the quantity of snacks that will be purchased for the party. Same with drinks.
    The exercise proposes storing the dateTime as a String to simplify the code. If you feel like investigating you can try saving it as an object of the LocalDateTime class.
    A constructor will be created, which will receive the type, dateTime, address, drinks and snacks through parameters. The guest property will be assigned the value 0 directly.
    Another constructor will be created that does not receive any parameters. Assign invented values ​​to each property.
    The consult() method will return a string with all the party data.
    The invite() method will add 1 to the guest counter.
    The cancelInvite() method will subtract 1 from the guest counter.
    The PartyPrice() method will return the price of the party calculated as follows: 5 euros for each guest, 2 euros for each drink and 3 euros for each sandwich.


Create a Main class (with main method) where you will create several objects of the Party class using several different constructors. Put into practice all the methods you have created (invite, consult, cancelInvite and PartyPrice).


Specifications for version 2:

    Creates a static attribute called PartyCounter, whose value will be incremented by one each time a new Party object is built.
    Place the Fiesta class in the com.itt.fiestas package.
    Overloads the invite method so that the user can make more than one invitation at a time by indicating the number of guests as an argument.
    Modify the Main class so that you can implement the changes introduced in this version 2.


