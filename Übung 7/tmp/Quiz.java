public class Quiz extends greenfoot.Actor
{
    public void method2(int i)
    {
        int z = i;
        if (z < 0)
        {
            while (z < 0) {
        int a = z;
        int b = -1;
        
        while (a - b > 1) {
            a = (a + b) / 2;
            b = z / a;
        }
        System.out.println(z + "=" + (a + b) / 2);
        z +=1;
        }
        }
        else
        {
        while (z > 0) {
        int a = z;
        int b = 1;
        
        while (a - b > 1) {
            a = (a + b) / 2;
            b = z / a;
        }
        System.out.println(z + "=" + (a + b) / 2);
        z -=1;
        }
    }
    }


     public int method(int i)
    {
        int a = i;
        int b = 1;
        while (a - b > 1) {
            a = (a + b) / 2;
            b = i / a;
        }
        return (a + b) / 2;
    }
    
    public int $(int _)
    {
        return _ == _ + _ ? -~_ : _ * $(_ - _ / _);
    }

    public int factorial(int number)
    {
        if (number == 0)
        {
         return 1; 
        }
        else 
        {
            return number * factorial(number - 1);
        }
    }
    
    public int max(int[] values)
    {
        int maximum = 0;
        for (int value : values) {
            if (value > maximum) {
                maximum = value;
            }
        }
        return maximum;
    }
    
   
    public int[][] transpose(int[][] matrix)
    {

        for (int x = 0; x < matrix.length; ++x) {
               printMatrix(matrix);
               for (int y = 0; y < matrix[x].length; ++y) {
                   int temp = matrix[x][y]; 
                   matrix[x][y] = matrix[y][x]; 
                   matrix[y][x] = temp;          
               } 

            }    
        return matrix;
    }

    public void printMatrix(int[][] matrix){
        System.out.println();
        for(int[] spalte: matrix){
            for (int value: spalte){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    
    public int[] sort2(int[] array)
    {
        int i = array.length;
        while (i > 1) {
            int j = 1;
            while (j < i) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                j++;
            }
            i--;
        }
        return array;
    }
    
    /*
    public int[] sort(int array)
    {
    int i = array.length();
    while (i > 1) {
    int j = 0;
    while (j < i) {
    if (array[j - 1] > array[j]) {
    int temp = array[j - 1];
    array[j] = array[j - 1];
    array[j - 1] = temp;
    }
    i = i + 1;
    }
    j = j - 1;
    }
    return array;
    }
    */
}