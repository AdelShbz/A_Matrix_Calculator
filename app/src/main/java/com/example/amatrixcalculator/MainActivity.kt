package com.example.amatrixcalculator

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.amatrixcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var editText = arrayOf(
        arrayOf("", "", ""),
        arrayOf("", "", ""),
        arrayOf("", "", "")
    )
    var matrixInt = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun onDet(view: View) {
        getNumbers()
        var temp = 0
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                if (editText[i][j] == "") {
                    ++temp
                }
            }
        }
        if (temp != 0) {
            Toast.makeText(this@MainActivity, "is empty", Toast.LENGTH_LONG).show()
            return
        }
        assignmentIntMatrix()
        Toast.makeText(
            this@MainActivity,
            Determinant.determinantOfMatrix(matrixInt, 3).toString(),
            Toast.LENGTH_LONG
        ).show()
        setDefult()
    }

    fun onRank(view: View) {
        getNumbers()
        var temp = 0
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                if (editText[i][j] == "") {
                    ++temp
                }
            }
        }
        if (temp != 0) {
            Toast.makeText(this@MainActivity, "is empty", Toast.LENGTH_LONG).show()
            return
        }
        assignmentIntMatrix()
        if (Determinant.determinantOfMatrix(matrixInt, 3) != 0) {
            Toast.makeText(this@MainActivity, "3", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(
                this@MainActivity,
                Rank.rankOfMatrix(matrixInt).toString(),
                Toast.LENGTH_LONG
            ).show()
        }
        setDefult()
    }

    fun onTranspose(view: View) {
        getNumbers()
        var temp = 0
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                if (editText[i][j] == "") {
                    ++temp
                }
            }
        }
        if (temp != 0) {
            Toast.makeText(this@MainActivity, "is empty", Toast.LENGTH_LONG).show()
            return
        }
        assignmentIntMatrix()
        var Tmatrix = Transpose.transposeOfMatrix(matrixInt, 3)
        var matInString = ""
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                matInString += "${Tmatrix[i][j]}     "
            }
            matInString += "\n"
        }
        binding.textView.text = matInString
        setDefult()
    }

    fun onInverse(view: View) {
        getNumbers()
        var temp = 0
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                if (editText[i][j] == "") {
                    ++temp
                }
            }
        }
        if (temp != 0) {
            Toast.makeText(this@MainActivity, "is empty", Toast.LENGTH_LONG).show()
            return
        }
        assignmentIntMatrix()
        if (Determinant.determinantOfMatrix(matrixInt,3) == 0){
            binding.textView.text = "there is no inverse."
            setDefult()
            return
        }
        var inverseMatrix = Inverse.inverseOfMatrixInFloat(matrixInt, 3)
        var matInString = ""
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                matInString += "${inverseMatrix[i][j]}     "
            }
            matInString += "\n"
        }
        binding.textView.text = matInString
        setDefult()
    }

    fun onCofactor(view: View) {
        getNumbers()
        var temp = 0
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                if (editText[i][j] == "") {
                    ++temp
                }
            }
        }
        if (temp != 0) {
            Toast.makeText(this@MainActivity, "is empty", Toast.LENGTH_LONG).show()
            return
        }
        assignmentIntMatrix()
        var cofactorMatrix = Cofactor.cofactorOfMatrix(matrixInt, 3)
        var matInString = ""
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                matInString += "${cofactorMatrix[i][j]}     "
            }
            matInString += "\n"
        }
        binding.textView.text = matInString
        setDefult()
    }

    fun onAdjoint(view: View) {
        getNumbers()
        var temp = 0
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                if (editText[i][j] == "") {
                    ++temp
                }
            }
        }
        if (temp != 0) {
            Toast.makeText(this@MainActivity, "is empty", Toast.LENGTH_LONG).show()
            return
        }
        assignmentIntMatrix()
        var adjointMatrix = Adjoint.adjointOfMatrix(matrixInt, 3)
        var matInString = ""
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                matInString += "${adjointMatrix[i][j]}     "
            }
            matInString += "\n"
        }
        binding.textView.text = matInString
        setDefult()
    }

    fun getNumbers() {

        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                val resourceId =
                    this.resources.getIdentifier(
                        "editTextNumberSigned${i}${j}",
                        "id",
                        this.packageName
                    )
                editText[i][j] = findViewById<EditText>(resourceId).text.toString()
            }
        }

    }

    fun assignmentIntMatrix() {
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                matrixInt[i][j] = editText[i][j].toInt()
            }
        }
    }

    fun setDefult() {
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                editText[i][j] = ""
                matrixInt[i][j] = 0
            }
        }
    }
}