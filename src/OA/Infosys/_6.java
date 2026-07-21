package OA.Infosys;

import java.util.*;

/*
==================================================
QUESTION: MINIMUM DISTINCT PEOPLE IN A SHOP
==================================================

You are the guard of a shop.

Each time a person enters or leaves the shop,
you note this information.

You are given the information in the form of
a binary string S.


If:

S[i] = '1'

It means a person ENTERS the shop.


If:

S[i] = '0'

It means a person LEAVES the shop.


A person can enter or leave the shop any number
of times.


Using the given information, find the MINIMUM
possible number of DISTINCT people that you
might have seen.


==================================================
INPUT FORMAT
==================================================

A binary String S containing only:

'0' and '1'


==================================================
CONSTRAINTS
==================================================

1 <= S.length() <= 10^5


==================================================
SAMPLE INPUT 1
==================================================

000


==================================================
SAMPLE OUTPUT 1
==================================================

3


==================================================
EXPLANATION
==================================================

String:

000


At time 1:

Person 1 leaves.


At time 2:

There is nobody known to be inside.

So Person 2 must leave.


At time 3:

Again there is nobody known to be inside.

So Person 3 must leave.


Therefore:

Minimum distinct people = 3


==================================================
SAMPLE INPUT 2
==================================================

110011


==================================================
SAMPLE OUTPUT 2
==================================================

2


==================================================
EXPLANATION
==================================================

String:

110011


Time 1:

Person 1 enters.


Time 2:

Person 2 enters.


Time 3:

Person 1 leaves.


Time 4:

Person 2 leaves.


Time 5:

Person 1 can enter again.


Time 6:

Person 2 can enter again.


Therefore:

Only 2 distinct people are required.


Minimum distinct people = 2


==================================================
SAMPLE INPUT 3
==================================================

10101


==================================================
SAMPLE OUTPUT 3
==================================================

1


==================================================
EXPLANATION
==================================================

String:

10101


Time 1:

Person 1 enters.


Time 2:

Person 1 leaves.


Time 3:

Same Person 1 enters again.


Time 4:

Same Person 1 leaves again.


Time 5:

Same Person 1 enters again.


Therefore:

Minimum distinct people = 1


==================================================
APPROACH
==================================================

We use two variables:


inside

= Number of people currently inside the shop.


people

= Minimum number of distinct people required.


--------------------------------------------------

CASE 1:

If current character is '1':

A person enters.

So:

inside++


If the number of people currently inside becomes
greater than the distinct people counted so far:

Update:

people = Math.max(people, inside)


--------------------------------------------------

CASE 2:

If current character is '0':

A person leaves.


If:

inside > 0

It means someone already inside can leave.

So:

inside--


But if:

inside == 0

Nobody is currently known to be inside.

Still, the information says someone left.

Therefore, this must be a new distinct person
who was already inside before we started observing.

So:

people++


==================================================
CODE
==================================================
*/

class Main6
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);


        // Input binary string

        String str = sc.nextLine();


        // Function call after input

        int answer = minimumPeople(str);


        // Print answer

        System.out.println(answer);
    }


    static int minimumPeople(String str)
    {
        int inside = 0;

        int people = 0;


        for(int i = 0; i < str.length(); i++)
        {
            // Person enters the shop

            if(str.charAt(i) == '1')
            {
                inside++;


                // Update minimum distinct people

                people = Math.max(people, inside);
            }


            // Person leaves the shop

            else
            {
                // Someone is already inside

                if(inside > 0)
                {
                    inside--;
                }


                // Nobody is currently inside
                // So a new distinct person is required

                else
                {
                    people++;
                }
            }
        }


        return people;
    }
}


/*

==================================================
SAMPLE INPUT 1
==================================================

000


==================================================
SAMPLE OUTPUT 1
==================================================

3


==================================================
DRY RUN 1
==================================================

str = "000"


Initially:

inside = 0
people = 0


----------------------------------

i = 0

str[i] = '0'


inside == 0

So:

people++

people = 1


----------------------------------

i = 1

str[i] = '0'


inside == 0

So:

people++

people = 2


----------------------------------

i = 2

str[i] = '0'


inside == 0

So:

people++

people = 3


Answer:

3


==================================================
SAMPLE INPUT 2
==================================================

110011


==================================================
SAMPLE OUTPUT 2
==================================================

2


==================================================
DRY RUN 2
==================================================

Initially:

inside = 0
people = 0


----------------------------------

Character = 1

inside = 1

people = max(0, 1)

people = 1


----------------------------------

Character = 1

inside = 2

people = max(1, 2)

people = 2


----------------------------------

Character = 0

inside > 0

inside = 1


----------------------------------

Character = 0

inside > 0

inside = 0


----------------------------------

Character = 1

inside = 1

people = max(2, 1)

people = 2


----------------------------------

Character = 1

inside = 2

people = max(2, 2)

people = 2


Final Answer:

2


==================================================
SAMPLE INPUT 3
==================================================

10101


==================================================
SAMPLE OUTPUT 3
==================================================

1


==================================================
DRY RUN 3
==================================================

Character     inside     people

1               1          1

0               0          1

1               1          1

0               0          1

1               1          1


Final Answer:

1


==================================================
TIME COMPLEXITY
==================================================

O(N)


==================================================
SPACE COMPLEXITY
==================================================

O(1)

*/