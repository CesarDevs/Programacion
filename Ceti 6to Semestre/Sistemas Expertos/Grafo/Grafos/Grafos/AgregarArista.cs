using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Grafos;
using Microsoft.VisualStudio.grap
//using System



namespace Grafos
{
    public partial class AgregarArista : Form
    {
        public AgregarArista()
        {
            InitializeComponent();
           
        }

        private void btAgregar_Click(object sender, EventArgs e)
        {
           
            

                object De = GA.Graph[tbDe.Text];
            //bool x = GA.G.ContainsKey(tbDe.Text);
            //bool y = GA.Grafo.ContainsKey(tbA.Text);

            if (GA.Graph.ContainsKey(tbDe.Text) && GA.Graph.ContainsKey(tbA.Text))
                {
                    object A = GA.Graph[tbA.Text];
                    if (De != null)
                    {
                        List<Tuple<string, string>> Vertices =  GA.Graph[tbDe.Text];
                        Tuple<string,string> Vertice = Tuple.Create(tbA.Text, tbCosto.Text);
                        Vertices.Add(Vertice);

                        GA.Graph.Remove(tbDe.Text);
                        GA.Graph.Add(tbDe.Text, Vertices);


                    }
                    else
                    {
                        List<Tuple<string, string>> Vertices = new List<Tuple<string, string>>();
                        var Vertice = Tuple.Create(tbA.Text, tbCosto.Text);
                        Vertices.Add(Vertice);
                        GA.Graph.Remove(tbDe.Text);
                        GA.Graph.Add(tbDe.Text, Vertices);
                    }
                    MessageBox.Show("Se agrego correctamete");
                    this.Close();
                }

                
            else
            {
                MessageBox.Show("No existe el vertice o arista");
            }




        
            
        }
    }
}
