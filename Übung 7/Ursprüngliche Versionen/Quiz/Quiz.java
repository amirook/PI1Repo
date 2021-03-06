public class Quiz extends greenfoot.Actor
{
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
        for (int y = 0; y < matrix.length; ++y) {
            for (int x = 0; x < matrix[y].length; ++x) {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = temp;
            }
        }
        return matrix;
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