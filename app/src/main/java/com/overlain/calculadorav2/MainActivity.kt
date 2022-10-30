package com.overlain.calculadorav2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Seteamos el boton de limpiar texto
        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""

        }

        //Seteamos el boton de (
        button_bracket_left.setOnClickListener {
            input.text = addToInputText(buttonValue = "(")
        }
        //Seteamos el boton de )
        button_bracket_right.setOnClickListener {
            input.text = addToInputText(buttonValue = ")")
        }
        //Seteamos el boton 0
        button_0.setOnClickListener {
            input.text = addToInputText(buttonValue = "0")
        }
        //Seteamos el boton 1
        button_1.setOnClickListener {
            input.text = addToInputText(buttonValue = "1")
        }
        //Seteamos el boton 2
        button_2.setOnClickListener {
            input.text = addToInputText(buttonValue = "2")
        }
        //Seteamos el boton 3
        button_3.setOnClickListener {
            input.text = addToInputText(buttonValue = "3")
        }
        //Seteamos el boton 4
        button_4.setOnClickListener {
            input.text = addToInputText(buttonValue = "4")
        }
        //Seteamos el boton 5
        button_5.setOnClickListener {
            input.text = addToInputText(buttonValue = "5")
        }
        //Seteamos el boton 6
        button_6.setOnClickListener {
            input.text = addToInputText(buttonValue = "6")
        }
        //Seteamos el boton 7
        button_7.setOnClickListener {
            input.text = addToInputText(buttonValue = "7")
        }
        //Seteamos el boton 8
        button_8.setOnClickListener {
            input.text = addToInputText(buttonValue = "8")
        }
        //Seteamos el boton 9
        button_9.setOnClickListener {
            input.text = addToInputText(buttonValue = "9")
        }
        //Seteamos el boton del punto
        button_dot.setOnClickListener {
            input.text = addToInputText(buttonValue = ".")
        }
        //Seteamos el boton division
        button_division.setOnClickListener {
            input.text = addToInputText(buttonValue = "÷")
        }
        //Seteamos el boton multiplicacion
        button_multiply.setOnClickListener {
            input.text = addToInputText(buttonValue = "×")
        }
        //Seteamos el boton resta/menor
        button_subtraction.setOnClickListener {
            input.text = addToInputText("-")
        }
        //Seteamos el boton suma
        button_addition.setOnClickListener {
            input.text = addToInputText("+")
        }

        button_equals.setOnClickListener {
            showResult()
        }

    }

    //Creamos una funcion para leer el input de los botones
    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    //Creamos una funcione de obtener el input de las expresiones
    private fun getInputExpression(): String {
        //Convertimos "÷" a su signo correspondiente "/"
        var expression = input.text.replace(Regex(pattern = "÷"), replacement = "/")
        //Convertimos "×" a su signo correspondiente "*"
            expression = expression.replace(Regex("×"), replacement = "*")
        //Retornamos la expression
        return expression
    }
    //Creamos una funcion para mostrar el resultado
    private fun showResult(){
        try {
                //Creamos una variable fija y le asignamos el valor de obtener el input de la expresion
                val expression = getInputExpression()
                //Creamos una variable fija y le asignamos la variable expresion y agregamos el calculate de la libreria
                val result = Expression(expression).calculate()
            if (result.isNaN()){
                //Muestra el mensaje de error
                output.text = "Error! :("
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            } else {
                // Muestra el resultado
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception){
            // Muestra el mensaje de error
            output.text = "Error! :("
            output.setTextColor(ContextCompat.getColor(this, R.color.green))
        }
    }
}