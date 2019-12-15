using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task6
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Enter your text: ");
            string s = Console.ReadLine();
            int k = s.Length;
            
            for (int i=k-1; i>=0; i--)
            {
                Console.Write(s[i]);
            }
            Console.ReadLine();
        }
    }
}
