// ------------------------------------------------------- 
// Assignment 4
// Written by: Tushar Raval - 40124664
// For COMP 248 Section EE – Fall 2019
// --------------------------------------------------------

import java.util.Random; // importing the Random method to randomly generate numbers 

/*
* this program generates 10000 passwords from alice and the wonderland. 
*/

public class question1{

    public static void main(String[] args) {

        System.out.println("Welcome to the password generator game! \n");

        // declaring all the variables and counts that are used in the program 
        int ctlength = 0, ctnline = 0, ctequal = 0, ctlength2 = 0, ctupper = 0, ctlower = 0, ctspec = 0, ctpass = 0, ctspec2 = 0; 
        boolean r = false; 
        
        // the use of 2 loops (1 do while, 1 while) 
        while (ctpass < 10000){
            do{
                r = false; // reseting the boolean if it gets tripped by one of the if statements 

                if (ctspec != 0){ // if the count special (6.e) is not 1, it will reset the counter and add another count for not meeting the special case requirements from below
                    ctspec2++;
                    ctspec = 0;
                }

                String [] arrpass = {randomWord(), randomWord(), randomWord()}; // generates random passwords in an array (using the created method below)

                for (int i = 0; i < arrpass.length; i++){ // this for loop checks if the words selected meet requirements 5 and 6.a. 

                    if (arrpass[i].contentEquals("\n")){ // checks if the workds aren't the newline char. 
                        r = true;
                        ctnline++;
                        break;
                    }
                    if (arrpass[i].length() == 1){ // checks if the words aren't one char. long
                        r = true;
                        ctlength++;
                        break;
                    }
                    if (arrpass[i].equals(arrpass[(i+1)%3])){ // checks if the words are the same or not 
                        r = true;
                        ctequal++;
                        break;
                    }
                }

                if (r){
                    break;
                }

                String password = ("");

                for (int i = 0; i < arrpass.length; i++){  // this for loop combines the words into one password if the for loop conditions above are met 
                    password += arrpass[i];
                }
                
                
                if (password.length() < 8 | password.length() >16){ // this if statement makes sure the password is not less then 8 char, and not more than 16 char (6.b)
                    ctlength2++;
                    r = true;
                }
                if ((password.compareTo(password.toLowerCase())) == 0){ // this if statement compares the password to its lower case form, to check for uppercase char. (6.c)
                    ctupper++;
                    r = true;
                }
                if ((password.compareTo(password.toUpperCase())) == 0){ // this if statement compares the password to its upper case form, to check for lowercase char. (6.d)
                    ctlower++;
                    r = true;
                }
                
                if (r){
                    break;
                }
                
                String [] special =  {"!","@","]","#","$","%","^","&","*","(",")","\"",".",",","\'","-", ";"}; // here we put all the spcial char into an array 
                String [] arrpass1 = password.split(""); // here we split the password into an array 
        
                for (int i = 0; i < special.length; i++){                   // this for loop checks if the password has any special char. in it 
                    for (int j = 0; j < arrpass1.length ; j++){
                        if ((arrpass1[j].compareTo(special[i])) == 0){
                            ctspec++;
                        }
                    }
                }
                

               if (ctspec != 1){    // this if statement makes sure there is only one special char in the password (6.e)
                   break;
                }

                // if all the condiontions are met, the password will be printed and all the required counters will be reset to 0 

                System.out.printf("Password = %-22s Newline = %-5d Single = %-5d Equal = %-5d Lenght = %-5d Upper = %-5d Lower = %-5d Special = %-5d\n",
                password, ctnline, ctlength, ctequal, ctlength2, ctupper, ctlower, ctspec2);

                ctpass++;
                ctlength = 0;
                ctnline = 0;
                ctequal = 0;
                ctlength2 = 0;
                ctupper = 0;
                ctspec = 0;
                ctspec2 = 0;

                if (ctlower == 1){ // if the password does not meet the lower case requirement (6.d), the code will run once again and then break out of the loop
                    ctlower++;
                    break;
                }

            }
            while(r);
            if (ctlower == 2){ // if the passwords generated has not met the lower case requirement (6.d), it will break and end the program 
                break;
            }
        }
        System.out.println("\nTotal passwords generated: " + ctpass + "\n");
        System.out.println("Thank you for using the password generator game! Good bye.");

    }




    public static String randomWord(){ 
        
        /* this method randomly generates a word from the array 'book'. 
        it is used so that we can call it multiple times without writing it again and again */
        
        final String[][][] book = {
            {
             {"ALICE was beginning to get very tired of sitting by her sister on the \n", 
             "bank, and of having nothing to do. Once or twice she had peeped into the \n", 
             "book her sister was reading, but it had no pictures or conversations in \n", 
             "it, \"and what is the use of a book,\" thought Alice, \"without pictures or \n", 
             "conversations?\" \n"},
             {"So she was considering in her OWN mind (as well as she could, for the \n", 
             "day made her feel very sleepy and stupid), whether the pleasure of \n", 
             "making a daisy-chain would be worth the trouble of getting up and \n", 
             "picking the daisies, when suddenly a White Rabbit with pink eyes ran \n", 
             "close by her. \n"},
             {"There was nothing so very remarkable in that, nor did Alice think it so \n", 
             "very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh \n", 
             "dear! I shall be too late!\" But when the Rabbit actually took a watch \n", 
             "out of its waistcoat-pocket and looked at it and then hurried on, Alice \n", 
             "started to her feet, for it flashed across her mind that she had never \n", 
             "before seen a rabbit with either a waistcoat-pocket, or a watch to take \n", 
             "out of it, and, burning with curiosity, she ran across the field after \n", 
             "it and was just in time to see it pop down a large rabbit-hole, under \n", 
             "the hedge. In another moment, down went Alice after it!"}
            },{
             {"\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a \n", 
             "telescope!\" \n"},
             {"And so it was indeed! She was now only ten inches high, and her face \n", 
             "brightened up at the thought that she was now the right size for going \n", 
             "through the little door into that lovely garden. \n"},
             {"After awhile, finding that nothing more happened, she decided on going \n", 
             "into the garden at once; but, alas for poor Alice! When she got to the \n", 
             "door, she found she had forgotten the little golden key, and when she \n", 
             "went back to the table for it, she found she could not possibly reach \n", 
             "it: she could see it quite plainly through the glass and she tried her \n", 
             "best to climb up one of the legs of the table, but it was too slippery, \n", 
             "and when she had tired herself out with trying, the poor little thing \n", 
             "sat down and cried. \n"},
             {"\"Come, there's no use in crying like that!\" said Alice to herself rather \n",
             "sharply. \"I advise you to leave off this minute!\" She generally gave \n", 
             "herself very good advice (though she very seldom followed it), and \n", 
             "sometimes she scolded herself so severely as to bring tears into her \n", 
             "eyes. \n"},
             {"Soon her eye fell on a little glass box that was lying under the table: \n", 
             "she opened it and found in it a very small cake, on which the words \"EAT \n", 
             "ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said \n", 
             "Alice, \"and if it makes me grow larger, I CAN reach the key; and if it \n", 
             "makes me grow smaller, I can creep under the door: so either way I'll \n", 
             "get into the garden, and I don't care which happens!\" \n"},
             {"She ate a little bit and said anxiously to herself, \"Which way? Which \n", 
             "way?\" holding her hand on the top of her head to feel which way she was \n", 
             "growing; and she was quite surprised to find that she remained the same \n", 
             "size. So she set to work and very soon finished off the cake."} 
            },{
             {"The King and Queen of Hearts were seated on their throne when they \n", 
             "arrived, with a great crowd assembled about them--all sorts of little \n", 
             "birds and beasts, as well as the whole pack of cards: the Knave was \n", 
             "standing before them, in chains, with a soldier on each side to guard \n", 
             "him; and near the King was the White Rabbit, with a trumpet in one hand \n", 
             "and a scroll of parchment in the other. In the very middle of the court \n", 
             "was a table, with a large DISH of tarts upon it. \"I wish they'd get the \n", 
             "trial done,\" Alice thought, \"and hand 'round the refreshments!\" \n"},
             {"The judge, by the way, was the King and he wore his crown over his great \n", 
             "wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures \n", 
             "(some were animals and some were birds) I suppose they are the jurors.\" \n"},
             {"Just then the White Rabbit cried out \"Silence in the court!\" \n"}, 
             {"\"HERALD! read the accusation!\" said the King."}
            }
        };

        Random rand = new Random();
        int pgnumber = rand.nextInt(3);
        int paragraph = rand.nextInt(book[pgnumber].length);
        int sentence = rand.nextInt(book[pgnumber][paragraph].length);
        String selected = book [pgnumber][paragraph][sentence];
        String [] arrsentence = selected.split(" ");
        String word = arrsentence[rand.nextInt(arrsentence.length)];
        return word;
    }
}