/******************************************************************************
 *  Name: Wurood Mandawi       
 *  NetID:     
 *  Precept:    
 *
 *  Partner Name:       
 *  Partner NetID:      
 *  Partner Precept:    
 *
 *  Hours to complete assignment (optional): 50
 *
 ******************************************************************************/


/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in synsets.txt. Why did you make this choice?
 *****************************************************************************/
I used two HashMaps to store data (synsets and hypernyms) so I could go both ways for example
field1 -> field2
field2 -> field1
I also used an ArrayList to Store Integer data


/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in hypernyms.txt. Why did you make this choice?
 *****************************************************************************/
I used HashMap of integer and string and a Digraph 


/******************************************************************************
 *  Describe concisely the algorithm you use in the constructor of
 *  ShortestCommonAncestor to check if the digraph is a rooted DAG.
 *  What is the order of growth of the worst-case running times of
 *  your algorithms as a function of the number of vertices V and the
 *  number of edges E in the digraph?
 *****************************************************************************/

Description: To check for rooted I first find the number of roots by having 
a for loop that goes through all the vertices in the digraph and add up the roots
the I have an if statement to check if the roots are more than 1 and if there is 
a cycl if so then i through an exception



Order of growth of running time: The order is just V because there is a for loop
that goes through all the vertices.


/******************************************************************************
 *  Describe concisely your algorithm to compute the shortest common
 *  ancestor in ShortestCommonAncestor. What is the order of growth of
 *  the running time of your methods as a function of the number of
 *  vertices V and the number of edges E in the digraph? What is the
 *  order of growth of the best-case running time?
 *
 *  If you use hashing, you should assume the uniform hashing assumption
 *  so that put() and get() take constant time.
 *
 *  Be careful! If you use a BreadthFirstDirectedPaths object, don't
 *  forget to count the time needed to initialize the marked[],
 *  edgeTo[], and distTo[] arrays.
 *****************************************************************************/

Description: I used two BreadthFirstDirectedPaths. I created two private methods
to compute the distance and ancestor. One is for Itrable data type and the other
for ints. In these two methods I do exactly the same thing except one takes
an itrable and the other takes an int
I have two BFDP object in each. and I go through all the vertices
then if theer is a path from the BFSs to the int I am in right now
then I add it to the ArrayList I have.

Then i have another for each loop that goes throught the ancestors I have
found and check  if the distance is less than the distance i have found
then I update the distance to this new distance and I update the ancestor
as well. 
and then I add these two to an array and i return the array. and i call
this meathod in length() and ancestor().
                                              running time
method                               best case            worst case
------------------------------------------------------------------------
length(int v, int w)						

ancestor(int v, int w)

length(Iterable<Integer> v,
       Iterable<Integer> w)

ancestor(Iterable<Integer> v,
         Iterable<Integer> w)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
N/A

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
Josh helped me understanding how I could use two BFS
Professor Li Han explained to me wordnet class and how I can use 
two HashMap to implement my idea

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
N/A

/******************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 *****************************************************************************/
N/A



/**********************************************************************
 *  Have you completed the mid-semester survey? If you haven't yet,
 *  please download this readme again when the link to the survey is included: 
 * 
 ***********************************************************************/
N/A

/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 ***************************************************************************/
I enjoed doing this assignment and I learned a lot form it, but it was hard
and took a very long time. The two classes professor Li Han suggested to me 
when I asked her for help in wordnet, Degrees of Separation and  Symbol Digraph,
were very helpful.