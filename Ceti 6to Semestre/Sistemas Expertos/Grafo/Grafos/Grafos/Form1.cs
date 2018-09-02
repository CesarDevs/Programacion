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





namespace Grafos
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
           
        }

        private void btAgregarVertice_Click(object sender, EventArgs e)
        {
            Grafos.AgregarVertices av = new AgregarVertices();
            av.Show();

        }

        private void btAgregarArista_Click(object sender, EventArgs e)
        {
            AgregarArista aa = new AgregarArista();
            aa.Show();
        }
    }
}
