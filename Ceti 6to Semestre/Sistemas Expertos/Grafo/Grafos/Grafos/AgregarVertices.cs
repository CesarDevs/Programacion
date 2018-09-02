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
using System.Collections;

namespace Grafos
{
    public partial class AgregarVertices : Form
    {
        public AgregarVertices()
        {
            InitializeComponent();
        }

        private void btAgregarAristas_Click(object sender, EventArgs e)
        {
            if (tbAristas.Text.Length > 0)
            {
                String Vertices= tbAristas.Text;
                String [] ArrayVertices = Vertices.Split(',');
                

                foreach(string x in ArrayVertices)
                {
                    //MessageBox.Show(x);

                    // String[] inf= {};
                    try
                    {
                        //Si existe en el grafo
                        GA.Graph.Add(x, null);
                        MessageBox.Show("Se Agrego el Vertice " + x.ToString());
                    }
                    catch
                    {
                        
                        MessageBox.Show("Ya existe el vertice " + x.ToString());
                    }
                    finally
                    {
                        this.Close();
                    }
                    

                }

                //foreach (string x in ArrayAristas)
                //{
                    
                  //  GA.Graph.Add();
                //}
           
                //MessageBox.Show(typeof(GA.Grafo['A']));





            }
            else
            {
                MessageBox.Show("Agrega el nombre de las vertices");

            }
        }
    }
}
