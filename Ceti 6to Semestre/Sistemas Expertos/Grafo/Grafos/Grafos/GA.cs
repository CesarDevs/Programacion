using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;


namespace Grafos
{

    public class GA
    {
        public static Hashtable Grafo = new Hashtable();
        public static Dictionary<String, List<Tuple<string,string>>> Graph = new Dictionary<string, List<Tuple<string,string>>>(); 

        public static Hashtable GetGrafo()
        {
            return Grafo;

        }
        public static Dictionary<String, List<Tuple<string, string>>> GetGraph()
        {
            return Graph;
                
        }

   
    }
}
