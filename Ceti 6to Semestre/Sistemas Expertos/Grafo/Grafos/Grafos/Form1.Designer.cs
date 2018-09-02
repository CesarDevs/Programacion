namespace Grafos
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.btAgregarVertice = new System.Windows.Forms.Button();
            this.btAgregarArista = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btAgregarVertice
            // 
            this.btAgregarVertice.Location = new System.Drawing.Point(12, 28);
            this.btAgregarVertice.Name = "btAgregarVertice";
            this.btAgregarVertice.Size = new System.Drawing.Size(330, 36);
            this.btAgregarVertice.TabIndex = 0;
            this.btAgregarVertice.Text = "Agregar Vertice";
            this.btAgregarVertice.UseVisualStyleBackColor = true;
            this.btAgregarVertice.Click += new System.EventHandler(this.btAgregarVertice_Click);
            // 
            // btAgregarArista
            // 
            this.btAgregarArista.Location = new System.Drawing.Point(12, 70);
            this.btAgregarArista.Name = "btAgregarArista";
            this.btAgregarArista.Size = new System.Drawing.Size(330, 36);
            this.btAgregarArista.TabIndex = 1;
            this.btAgregarArista.Text = "Agregar Arista";
            this.btAgregarArista.UseVisualStyleBackColor = true;
            this.btAgregarArista.Click += new System.EventHandler(this.btAgregarArista_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(354, 285);
            this.Controls.Add(this.btAgregarArista);
            this.Controls.Add(this.btAgregarVertice);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btAgregarVertice;
        private System.Windows.Forms.Button btAgregarArista;
    }
}

