
import java.util.Scanner;

public class TicTacToe{
    static int end;
    static int srt;
    static String[][] positionArray = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    static String[][] matrix = new String[][]{{"0", "0", "0"}, {"0", "0", "0"}, {"0", "0", "0"}};
    static String[][] matrixCopy=new String[][]{{"0", "0", "0"}, {"0", "0", "0"}, {"0", "0", "0"}};
    static String whosTurn;
    static int posistionInPositionArray;
    static int[] returnedPosition;
    static int areaInMatrix;
    static int placeArea;
    static TicTacToe obj;
    static String status;
    public static void main(String[] args) {
        whosTurn ="X";
        Scanner scan=new Scanner(System.in);
      obj=new TicTacToe();
      int count =0;
        obj.showmatrix(positionArray);
        while (count <9)
        {
            System.out.println("turn "+whosTurn);
            System.out.println("please choose the position you want from above matrix :");
            posistionInPositionArray=scan.nextInt();
            returnedPosition= obj.position(posistionInPositionArray);
            areaInMatrix=returnedPosition[0];
            placeArea=returnedPosition[1];
            if(matrix[areaInMatrix][placeArea]=="0")
            {
                count++;
                matrix[areaInMatrix][placeArea]=whosTurn;
                obj.showmatrix(matrix);

                status=obj.check(areaInMatrix,placeArea);
                if(status=="win")
                {
                    System.out.println(whosTurn +" is won the game ");
                    break;
                }
                whosTurn=(whosTurn=="X") ?  "O" : "X";

            }
            else{
                System.out.println("that is place is already filled with" +matrix[areaInMatrix][placeArea]);
            }
        }
        System.out.println("Game Is Draw Play Agian...");

    }
    public int[] position(int place){
        switch (place)
        {
            case 1:
                return new int[]{0,0};
            case 2:
                return new int[]{0,1};
            case 3:
                return new int[]{0,2};
            case 4:
                return new int[]{1,0};
            case 5:
                return new int[]{1,1};
            case 6:
                return new int[]{1,2};
            case 7:
                return new int[]{2,0};
            case 8:
                return new int[]{2,1};
            case 9:
                return new int[]{2,2};
        }
    return new int[]{0,0};
    }
    public void showmatrix(String[][] arr){
        for (int i = 0; i <= 2; i++)
        {
            for(int j=0;j<=2;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }

    }
    public String check(int areaInMatrix,int placeArea)
    {


        switch(areaInMatrix)
        {
            case 0:
                if (obj.fristHorizontalCheck()=="win")
                {
                    return "win";
                }
                if (placeArea==0)
                {
                    if (obj.firstVerticalCheck()=="win")
                    {
                        return "win";
                    }

                    if (obj.leftcrossCheck()=="win")
                    {
                        return "win";
                    }

                }
                if (placeArea==1)
                {
                    if (obj.secondVerticalCheck()=="win")
                    {
                        return "win";
                    }


                }
                if (placeArea==2)
                {
                    if (obj.thirdVerticalCheck()=="win")
                    {
                        return "win";
                    }
                    if (leftcrossCheck()=="win")
                    {
                        return "win";
                    }


                }
            break;
            case 1:
                if (obj.secondHorizontalCheck()=="win")
                {
                    return "win";
                }
                if (placeArea==0)
                {
                    if (obj.firstVerticalCheck()=="win")
                    {
                        return "win";
                    }


                }
                if (placeArea==1)
                {
                    if (obj.leftcrossCheck()=="win")
                    {
                        return "win";
                    }
                    if (obj.rightcrossCheck()=="win")
                    {
                        return "win";
                    }

                    if (obj.secondVerticalCheck()=="win")
                    {
                        return "win";
                    }


                }
                if (placeArea==2)
                {
                    if (obj.thirdVerticalCheck()=="win")
                    {
                        return "win";
                    }

                }
            break;
            case 2:
                if (obj.thirdHorizontalCheck()=="win")
                {
                    return "win";
                }
                if (placeArea==0)
                {
                    if (obj.firstVerticalCheck()=="win")
                    {
                        return "win";
                    }
                    if (obj.rightcrossCheck()=="win")
                    {
                        return "win";
                    }


                }
                if (placeArea==1)
                {
                    if (obj.secondVerticalCheck()=="win")
                    {
                        return "win";
                    }



                }
                if (placeArea==2)
                {
                    if (obj.thirdVerticalCheck()=="win")
                    {
                        return "win";
                    }
                    if (obj.leftcrossCheck()=="win")
                    {
                        return "win";
                    }

                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + areaInMatrix);
        }

        return "Loss";
    }
    public String fristHorizontalCheck()
    {
        if((matrix[0][0] == matrix[0][1]) && (matrix[0][0] == matrix[0][2]))
        {
            return "win";
        }
        return "Loss";
    }
    public String secondHorizontalCheck()
    {
        if((matrix[1][0] == matrix[1][1]) && (matrix[1][0] == matrix[1][2]))
        {
            return "win";
        }
        return "Loss";
    }
    public String thirdHorizontalCheck()
    {
        if((matrix[2][0] == matrix[2][1]) && (matrix[2][0] == matrix[2][2]))
        {
            return "win";
        }
        return "Loss";
    }
    public String firstVerticalCheck()
    {
        if((matrix[0][0] == matrix[1][0]) && (matrix[0][0] == matrix[2][0]))
        {
            return "win";
        }
        return "Loss";
    }
    public String secondVerticalCheck()
    {
        if((matrix[0][1] == matrix[1][1]) && (matrix[0][1] == matrix[2][1]))
        {
            return "win";
        }
        return "Loss";
    }
    public String thirdVerticalCheck()
    {
        if((matrix[2][0] == matrix[1][2]) && (matrix[2][0] == matrix[2][2]))
        {
            return "win";
        }
        return "Loss";
    }
    public String leftcrossCheck()
    {
        if((matrix[0][0] == matrix[1][1]) && (matrix[0][0] == matrix[2][2]))
        {
            return "win";
        }
        return "Loss";
    }
    public String rightcrossCheck()
    {
        if((matrix[0][2] == matrix[1][1]) && (matrix[0][2] == matrix[2][0]))
        {
            return "win";
        }
        return "Loss";
    }
    }
