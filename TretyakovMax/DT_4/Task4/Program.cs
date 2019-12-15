using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task4
{
    class Program
    {
        static void Main(string[] args)
        {
            Random rand = new Random();
            int k = rand.Next(101);
            int ans = 0, a=0, b=100;
            while (ans != k)
            {
                Console.Write("Enter a number from " + a.ToString() + " to " + b.ToString() + " ");
                try
                {
                    ans = int.Parse(Console.ReadLine());
                    if ((ans < b) && (ans > a))
                    {
                        if (ans == k)
                        {
                            Console.WriteLine("Your answer is right");
                            ans = k;
                        }
                        else
                        {
                            
                            if ((ans > k))
                            {
                                Console.WriteLine("Number is less");
                                b = ans;
                            }
                            else
                            {
                                Console.WriteLine("Number is bigger");
                                a = ans;
                            }
                        }
                    }
                    else
                    {
                        Console.WriteLine("Number should be from " + a.ToString() + " to " + b.ToString());
                    }
                    
                }
                catch(Exception e)
                {
                    Console.WriteLine("Your answer isn't valid");
                }
            }
            Console.ReadLine();
        }
    }
}
