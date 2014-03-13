# cs56-games-states-quiz
======================

Zhansaya Abdikarimova
Jenny Vien


## Description

* This application is a state quiz that tests the users' knowledge of the locations of states and capitals on the US map. As for the future, it can be advanced to choosing different countries and continents. 


* javadoc: http://www.cs.ucsb.edu/~zhansaya/cs56/W14/StateQuiz/javadoc/

## Documentation

* The main frame of the game is in the `GameFrame` class that holds two different main panels: `FrontPanel` and `GamePanel`. 

* When the quiz starts, it askes if the user wants to be tested on state locations or their capital locations. The initial cover page is in the `FrontPanel` class where there are two buttons for the two options. 

![](http://i.imgur.com/1IdD5Zv.png)

* After selecting option of the quiz, `GamePanel` class runs the selected option. The `GamePanel` class has three main parts, a MapPanel, a question scrollbar, and an answer scroll bar. The `MapPanel` class holds the map of the United States with buttons for every state. If user selects state option it asks questions about each state locations in random order, and if he or she selects state capitals option, the game will generate capital questions respectevily. Here are the examples of states and capitals quizes:  


![](http://i.imgur.com/XJQ9DyI.png)


![](http://i.imgur.com/ALQwhRo.png)



* All of the data is stored in the `States.txt` file. It has a list of states, their capitals and locations for buttons: ``` Alabama,Montgomery,495,310 ```

* The program reads data in the `Country` class. As you can see, in the constructor, every Country object has its name, capital and list of its states. It creates an `ArrayList` of `State` objects.  

```java
public Country(){
	states = new ArrayList<State>();
	this.name = null;
	this.capital = null;
}
``` 

The `State` class stores information about each state of a particular country

```java
public State(String name, String capital, int x, int y){
	this.name = name;
	this.capital = capital;
	this.xCoord = x;
	this.yCoord = y;
}
```
Below there is a method in `Country` class that reads all the information about the country from a file

```java
public void addStates(int numberOfStates, File file) throws Exception {
	Scanner scanner = new Scanner(file);

	String line;
	int x;
	int y;

	for(int i=0;i<numberOfStates;i++){
	    line = scanner.nextLine();
	    String[] splitted = line.split(",");

	    x=Integer.parseInt(splitted[2]);
	    y=Integer.parseInt(splitted[3]);
	    states.add(new State(splitted[0],splitted[1],x,y));
	    
	}
 }
```

* Another very important file that actually runs the game is `QuestionManager` class. It has the basic logic for running the quiz. It stores the list of states and their capitals, generates random indexes for the questions, and asks questions until all of the states asked. 

## How to run 
The main class in `GameMain` and in order to start the game, use `ant run`. 

### Ideas for future developers
There are several ways of how the game can be developed further:
	
	- game has quizzes for states and capitals mixed together
	- there is an option for continent, countries quizes
	- quizzes for states and capitals of other countries respectively
	- go back button for both state and capital quiz
	- ...

