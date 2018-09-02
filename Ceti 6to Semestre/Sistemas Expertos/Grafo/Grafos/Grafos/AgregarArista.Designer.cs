namespace Grafos
{
    partial class AgregarArista
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
            this.tbDe = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.tbA = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.btAgregar = new System.Windows.Forms.Button();
            this.tbCosto = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // tbDe
            // 
            this.tbDe.Location = new System.Drawing.Point(24, 43);
            this.tbDe.Name = "tbDe";
            this.tbDe.Size = new System.Drawing.Size(152, 22);
            this.tbDe.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(24, 20);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(30, 17);
            this.label1.TabIndex = 1;
            this.label1.Text = "De:";
            // 
            // tbA
            // 
            this.tbA.Location = new System.Drawing.Point(24, 105);
            this.tbA.Name = "tbA";
            this.tbA.Size = new System.Drawing.Size(152, 22);
            this.tbA.TabIndex = 2;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(24, 82);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(21, 17);
            this.label2.TabIndex = 3;
            this.label2.Text = "A:";
            // 
            // btAgregar
            // 
            this.btAgregar.Location = new System.Drawing.Point(67, 192);
            this.btAgregar.Name = "btAgregar";
            this.btAgregar.Size = new System.Drawing.Size(75, 23);
            this.btAgregar.TabIndex = 4;
            this.btAgregar.Text = "Aregar";
            this.btAgregar.UseVisualStyleBackColor = true;
            this.btAgregar.Click += new System.EventHandler(this.btAgregar_Click);
            // 
            // tbCosto
            // 
            this.tbCosto.Location = new System.Drawing.Point(24, 158);
            this.tbCosto.Name = "tbCosto";
            this.tbCosto.Size = new System.Drawing.Size(152, 22);
            this.tbCosto.TabIndex = 5;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(24, 138);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(48, 17);
            this.label3.TabIndex = 6;
            this.label3.Text = "Costo:";
            // 
            // AgregarArista
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(207, 227);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.tbCosto);
            this.Controls.Add(this.btAgregar);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.tbA);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.tbDe);
            this.Name = "AgregarArista";
            this.Text = "AgregarArista";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox tbDe;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox tbA;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btAgregar;
        private System.Windows.Forms.TextBox tbCosto;
        private System.Windows.Forms.Label label3;
    }
}