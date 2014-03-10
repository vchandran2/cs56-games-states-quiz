# cs56-games-states-quiz
======================

Zhansaya Abdikarimova
Jenny Vien


## Description

* This is a state quiz that currently tests knowledge about locations of states and their capitals on US map. As for the future, it can be advanced for choosing different countries and continents. 


* javadoc: http://www.cs.ucsb.edu/~zhansaya/cs56/W14/StateQuiz/javadoc/

## Documentation

* The main frame of the game is in `GameFrame` class that holds two different main panels: `FrontPanel` and `GamePanel`. 

* First when the quiz-game starts, it askes if user wants to be tested with states locations or their capital locations. The initial cover page is in `FrontPanel` class where there are two buttons for state or capital quizes. 

![](http://i.imgur.com/1IdD5Zv.png)

* After selecting option of the quiz, `GamePanel` class runs with selected option. The class has three main parts. One of the is panel called `MapPanel` that holds USA map with buttons for every state. Other two parts are questions scroll bar and correct answers scroll bar. If user selects state option it asks questions about each state locations in random order, and if he or she selects state capitals option, the game will generate capital questions respectevily. Here are the examples of states and capitals quizes:  


![](http://i.imgur.com/XJQ9DyI.png)


![](http://i.imgur.com/ALQwhRo.png)



* All data is in `States.txt` file. It has list of states, their capitals and locations for buttons for every state: ``` Alabama,Montgomery,495,310 ```

* The program reads data in `Country` class. As you can see, in the constructor, every Country object has its name, capital and list of its states. It creates `ArrayList` of `State` objects.  

```java
public Country(){
	states = new ArrayList<State>();
	this.name = null;
	this.capital = null;
}
``` 

The `State` class stores information about each state of particular country

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

* Another very important file that actually runs the game is `QuestionManager` class. It has the basic logic for running the quiz. It stores list of states and their capitals, generates random indexes for questions, and asks questions until all of the states asked. 

## How to run 
The main class in `GameMain` and in order to start the game, use `ant run`. 

### Ideas for future developers
There are several ways of how the game can be developed further:
	
	- game has quizes for states and capitals mixed together
	- there is an option for continent, countries quizes
	- quizes for states and capitals of other countries respectively
	- ...

