class Solution {
    public boolean isRobotBounded(String instructions) {
//      Variables to track the cordinates of robo
        int x = 0;
        int y = 0;

//      Variable to track the direction of robo
        char currentDirection = 'N';

//      Loop through the instructions
        for(char c: instructions.toCharArray()){

            switch(c){
//              If robo moves then based on current direction, update the value of 'x' or 'y'
                case 'G':{
                    if(currentDirection == 'N')
                        y++;
                    else if(currentDirection == 'E')
                        x--;
                    else if(currentDirection == 'S')
                        y--;
                    else
                        x++;
                }
                break;

//              If robo changes direction then based on current direction, update the direction
                case 'L':{
                    if(currentDirection == 'N')
                        currentDirection = 'W';
                    else if(currentDirection == 'E')
                        currentDirection = 'N';
                    else if(currentDirection == 'S')
                        currentDirection = 'E';
                    else
                        currentDirection = 'S';
                }
                break;

                case 'R':{
                    if(currentDirection == 'N')
                        currentDirection = 'E';
                    else if(currentDirection == 'E')
                        currentDirection = 'S';
                    else if(currentDirection == 'S')
                        currentDirection = 'W';
                    else
                        currentDirection = 'N';
                }
                break;
            }

        }

//      Robo will be moving in a circle, if either it returns to (0,0)
//      or if the final direction after one iteration is not North
        return ((x==0 && y==0) || (currentDirection != 'N'));

    }
}