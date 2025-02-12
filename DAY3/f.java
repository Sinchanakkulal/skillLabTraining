import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class f{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string ");
        String word=sc.next();

        String result=removeDuplicateword(word,0,new StringBuilder(),new HashSet<>());
        System.out.println("string with no duplicate word is :"+result);

        sc.close();
    }
    public static String removeDuplicateword(String word,int index,StringBuilder result,Set<Character> seen)
    {
        //base cae
        if(index>=word.length())
        {
            return result.toString();
        }

        char character=word.charAt(index);

        if(!seen.contains(character))
        {
            seen.add(character);
            result.append(character);
        }

        return removeDuplicateword(word,index+1,result,seen);
    }
}