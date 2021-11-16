# Elevator system design  algorithm 
#### by Dolev Dublon and Daniel Zaken

OOP First exercise ariel university.
In this task we are required to execute an algorithm, to find the best time for the total calls.

### Functions at the algorithm
- String algoName() 
return the algo name;
- int allocateAnElevator(CallForElevator c)
Decides which elevator to send to which call. Double Point data structure is used for sorting the calls. It stores the time and the index of the elevator to reach the call so we can choose the appropriate elevato. if the call is on the same direction the elevator is moving. Because of the condition, that the elevator can only stop if it get a call on the same direction. if the closest elevator is not suitable then We'll take the second most suitable elevator;
- void cmdElevator(int elev) 
-If it's an elevator that has no calls then do nothing.
if it has a call then give her the call and send and run goTo() the call src.
at every call of the cmdElevator(), we check if the floor the elevator at , it need to stop , we also check if there are more stops on the way upfront. if we stop at a floor we remove it from the list.
Checking if in the future I have a stop halfway, in case you get a call halfway.
-double timeCaculateForLevel(int elev, int src) 
we calculate the time it takes the elevator reach the source of the call.
-int fastestElevator()
we iterate all the elevators to get the fastest elevator.

## Class

- class DoublePoint
private int I;                           
private double time;

link to the UML charts
[UML Lucid Chart](https://lucid.app/lucidchart/367d4a61-87a4-4e4c-9767-a1dd49466575/edit?view_items=fqumZbE4oneC&invitationId=inv_5034536b-bfcf-4c2a-8c27-61bfd397e94f)

link to document 
https://docs.google.com/document/d/1l9ErmQOO43h7CWvSCi9qsfjrew41ir_hT2OwL72IgG4/edit?usp=sharing

link to instructions of part 1
https://docs.google.com/document/d/1KMsfQpuENR16Kfofs30KCxE95hSp7xnXXze5xyj-Y6c/edit
link to instructions of part 2
https://docs.google.com/document/d/1_lXbS2P2m_jZ2m7h-9oRC8FiJIOTpoIBJWo6lwJ6Pv8/edit?usp=sharing

![elevatorDesignSystemOOP1ArielUniversityDolevAndDaniel](https://user-images.githubusercontent.com/62290677/142063417-70130ef3-f64c-4da0-a917-e01be173d5b5.png)
