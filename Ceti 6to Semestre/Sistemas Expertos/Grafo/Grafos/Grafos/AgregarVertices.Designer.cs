namespace Grafos
{
    partial class AgregarVertices
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.tbAristas = new System.Windows.Forms.TextBox();
            this.btAgregarAristas = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 23);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(194, 17);
            this.label1.TabIndex = 0;
            this.label1.Text = "Agrege el nombre del vertice:";
            // 
            // tbAristas
            // 
            this.tbAristas.Location = new System.Drawing.Point(16, 43);
            this.tbAristas.Name = "tbAristas";
            this.tbAristas.Size = new System.Drawing.Size(254, 22);
            this.tbAristas.TabIndex = 1;
            // 
            // btAgregarAristas
            // 
            this.btAgregarAristas.Location = new System.Drawing.Point(12, 97);
            this.btAgregarAristas.Name = "btAgregarAristas";
            this.btAgregarAristas.Size = new System.Drawing.Size(258, 36);
            this.btAgregarAristas.TabIndex = 2;
            this.btAgregarAristas.Text = "Agregar";
            this.btAgregarAristas.UseVisualStyleBackColor = true;
            this.btAgregarAristas.Click += new System.EventHandler(this.btAgregarAristas_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(13, 68);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(199, 17);
            this.label2.TabIndex = 3;
            this.label2.Text = "(para barios separarlo con \",\")";
            // 
            // AgregarVertices
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(282, 145);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.btAgregarAristas);
            this.Controls.Add(this.tbAristas);
            this.Controls.Add(this.label1);
            this.Name = "AgregarVertices";
            this.Text = "AgregarVertices";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox tbAristas;
        private System.Windows.Forms.Button btAgregarAristas;
        private System.Windows.Forms.Label label2;
    }
}