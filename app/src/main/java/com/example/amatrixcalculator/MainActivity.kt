package com.example.amatrixcalculator

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
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
    fun setDefultVisibility(){
        binding.imageViewResultL.visibility = View.VISIBLE
        binding.imageViewResultR.visibility = View.VISIBLE
        binding.linearLayoutResult1.visibility = View.VISIBLE
        binding.linearLayoutResult2.visibility = View.VISIBLE
        binding.linearLayoutResult3.visibility = View.VISIBLE
        binding.textViewEqual2.visibility = View.VISIBLE
        binding.imageViewResultInverseL.visibility = View.VISIBLE
        binding.imageViewResultInverseR.visibility = View.VISIBLE
        binding.linearLayoutResultInv1.visibility = View.VISIBLE
        binding.linearLayoutResultInv2.visibility = View.VISIBLE
        binding.linearLayoutResultInv3.visibility = View.VISIBLE
        binding.textViewNumberResult.visibility = View.VISIBLE
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
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = matrixInt[i][j].toString()
            }
        }
        setDefultVisibility()
        binding.textViewOperation.text = "Det"
        binding.imageViewResultL.visibility = View.GONE
        binding.imageViewResultR.visibility = View.GONE
        binding.linearLayoutResult1.visibility = View.GONE
        binding.linearLayoutResult2.visibility = View.GONE
        binding.linearLayoutResult3.visibility = View.GONE
        binding.textViewEqual2.visibility = View.GONE
        binding.imageViewResultInverseL.visibility = View.GONE
        binding.imageViewResultInverseR.visibility = View.GONE
        binding.linearLayoutResultInv1.visibility = View.GONE
        binding.linearLayoutResultInv2.visibility = View.GONE
        binding.linearLayoutResultInv3.visibility = View.GONE
        binding.textViewNumberResult.text = Determinant.determinantOfMatrix(matrixInt, 3).toString()
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
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = matrixInt[i][j].toString()
            }
        }
        setDefultVisibility()
        binding.textViewOperation.text = "Rank"
        binding.imageViewResultL.visibility = View.GONE
        binding.imageViewResultR.visibility = View.GONE
        binding.linearLayoutResult1.visibility = View.GONE
        binding.linearLayoutResult2.visibility = View.GONE
        binding.linearLayoutResult3.visibility = View.GONE
        binding.textViewEqual2.visibility = View.GONE
        binding.imageViewResultInverseL.visibility = View.GONE
        binding.imageViewResultInverseR.visibility = View.GONE
        binding.linearLayoutResultInv1.visibility = View.GONE
        binding.linearLayoutResultInv2.visibility = View.GONE
        binding.linearLayoutResultInv3.visibility = View.GONE
        if (Determinant.determinantOfMatrix(matrixInt, 3) != 0) {
            binding.textViewNumberResult.text = "3"
        } else {
            binding.textViewNumberResult.text = Rank.rankOfMatrix(matrixInt).toString()
        }
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
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = matrixInt[i][j].toString()
            }
        }
        if (Determinant.determinantOfMatrix(matrixInt,3) == 0){
            setDefultVisibility()
            binding.textViewNumberResult.text = " there is no inverse."
            binding.textViewOperation.text = "Inverse"
            binding.imageViewResultL.visibility = View.GONE
            binding.imageViewResultR.visibility = View.GONE
            binding.linearLayoutResult1.visibility = View.GONE
            binding.linearLayoutResult2.visibility = View.GONE
            binding.linearLayoutResult3.visibility = View.GONE
            binding.textViewEqual2.visibility = View.GONE
            binding.imageViewResultInverseL.visibility = View.GONE
            binding.imageViewResultInverseR.visibility = View.GONE
            binding.linearLayoutResultInv1.visibility = View.GONE
            binding.linearLayoutResultInv2.visibility = View.GONE
            binding.linearLayoutResultInv3.visibility = View.GONE
            setDefult()
            return
        }
        setDefult()
        getNumbers()
        assignmentIntMatrix()
        setDefultVisibility()
        binding.textViewOperation.text = "Inverse"
        binding.textViewNumberResult.visibility = View.GONE
        var inverseMatrixInString = Inverse.inverseOfMatrixInString(matrixInt, 3)
        setDefult()
        getNumbers()
        assignmentIntMatrix()
        var inverseMatrixInFloat = Inverse.inverseOfMatrixInFloat(matrixInt, 3)
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResult${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = inverseMatrixInString[i][j]
            }
        }
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResultInverse${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = inverseMatrixInFloat[i][j].toString()
            }
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
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = matrixInt[i][j].toString()
            }
        }
        setDefultVisibility()
        binding.textViewOperation.text = "T"
        binding.textViewEqual2.visibility = View.GONE
        binding.imageViewResultInverseL.visibility = View.GONE
        binding.imageViewResultInverseR.visibility = View.GONE
        binding.linearLayoutResultInv1.visibility = View.GONE
        binding.linearLayoutResultInv2.visibility = View.GONE
        binding.linearLayoutResultInv3.visibility = View.GONE
        binding.textViewNumberResult.visibility = View.GONE
        var Tmatrix = Transpose.transposeOfMatrix(matrixInt, 3)
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResult${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = Tmatrix[i][j].toString()
            }
        }
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
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = matrixInt[i][j].toString()
            }
        }
        setDefultVisibility()
        binding.textViewOperation.text = "Cofactor"
        binding.textViewEqual2.visibility = View.GONE
        binding.imageViewResultInverseL.visibility = View.GONE
        binding.imageViewResultInverseR.visibility = View.GONE
        binding.linearLayoutResultInv1.visibility = View.GONE
        binding.linearLayoutResultInv2.visibility = View.GONE
        binding.linearLayoutResultInv3.visibility = View.GONE
        binding.textViewNumberResult.visibility = View.GONE
        var CofMatrix = Cofactor.cofactorOfMatrix(matrixInt, 3)
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResult${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = CofMatrix[i][j].toString()
            }
        }
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
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textView${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = matrixInt[i][j].toString()
            }
        }
        setDefultVisibility()
        binding.textViewOperation.text = "Adj"
        binding.textViewEqual2.visibility = View.GONE
        binding.imageViewResultInverseL.visibility = View.GONE
        binding.imageViewResultInverseR.visibility = View.GONE
        binding.linearLayoutResultInv1.visibility = View.GONE
        binding.linearLayoutResultInv2.visibility = View.GONE
        binding.linearLayoutResultInv3.visibility = View.GONE
        binding.textViewNumberResult.visibility = View.GONE
        var AdjMatrix = Adjoint.adjointOfMatrix(matrixInt, 3)
        for (i: Int in 0 until 3) {
            for (j: Int in 0 until 3) {
                val resourceId =
                    this.resources.getIdentifier(
                        "textViewResult${i}${j}",
                        "id",
                        this.packageName
                    )
                findViewById<TextView>(resourceId).text = AdjMatrix[i][j].toString()
            }
        }
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