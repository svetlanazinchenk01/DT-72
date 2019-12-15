using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task2
{
    class Program
    {
        static List<int> aList = new List<int>();
        static HashSet<int> mSet = new HashSet<int>();
        static int findM()
        {
            int m = 0;
            for (int i = 0; i < 151; i++)
            {
                if ((aList[i] > m) && (!mSet.Contains(aList[i]))){
                    m = aList[i];
                } 
            }
            mSet.Add(m);
            return m;
        }

        static void Main(string[] args)
        {
            List<int> bList = new List<int>();
            Random rand = new Random();
            int m = 0;
            for(int i=0; i<151; i++)
            {
                aList.Add(rand.Next(201));
               // Console.WriteLine(aList[i]);
            }
            while (bList.Count() < 15)
            {
                m = findM();
                //Console.WriteLine(m);
                for (int i = 0; i < 151; i++)
                {
                    if (aList[i] == m)
                    {
                        if (bList.Count < 15)
                        {
                            bList.Add(m);
                        }                       
                    }
                }
            }
            StreamWriter f = new StreamWriter("test.txt");
            Console.WriteLine("Your List:");
            for (int i = 0; i < 15; i++)
            {
               // aList.Add(rand.Next(201));
                 Console.WriteLine(bList[i]);
                f.WriteLine(bList[i]);
            }
            Console.WriteLine("File is located in bin/Debug");
            f.Close();
            Console.ReadLine();
        }
    }
}
