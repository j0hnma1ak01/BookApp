package com.example.assignment_8

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.assignment_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        val books: List<BookModel> = listOf(
            BookModel(
                "One Hundred Years of Solitude",
                "Gabriel Garcia Marquez",
                R.drawable.solitude,
                3.5f
            ),
            BookModel("Terra Nostra", "Carlos Fuentes", R.drawable.nostra, 3.0f),
            BookModel("Angles & Demons", "Dan Brown", R.drawable.angels, 4.0f),
            BookModel("The Sword Thief", "Peter Lerangis", R.drawable.sword, 2.0f),
            BookModel("Inferno", "Dan Brown", R.drawable.angels, 4.5f),
            BookModel("Bloodline", "James Rollins", R.drawable.blood, 2.0f),
            BookModel("The House of the Spirits", "Isabel Allende", R.drawable.spirits, 3.0f),
            BookModel("The Hummingbird`s Daughter", "Luis Alberto Urrea", R.drawable.humming, 3.5f),

            )
        bind.rv.adapter = BookAdapter(books)

        bind .topAppBar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.noti ->{
                    Toast.makeText(this, getString(R.string.notification_clicked),Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        bind.topAppBar.setNavigationOnClickListener {
            bind.drawerLayout.open()
        }

        bind.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.reviews     -> {
                    Toast.makeText(this, getString(R.string.reviews_clicked), Toast.LENGTH_SHORT).show()
                    bind.drawerLayout.close()
                    true
                }

                R.id.favorite -> {
                    Toast.makeText(this, getString(R.string.favorite_clicked), Toast.LENGTH_SHORT).show()
                    bind.drawerLayout.close()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, getString(R.string.search_clicked), Toast.LENGTH_SHORT).show()
                    bind.drawerLayout.close()
                    true
                }
                R.id.profile -> {
                    Toast.makeText(this, getString(R.string.profile_clicked), Toast.LENGTH_SHORT).show()
                    bind.drawerLayout.close()
                    true
                } R.id.settings -> {
                Toast.makeText(this, getString(R.string.settings_clicked), Toast.LENGTH_SHORT).show()
                bind.drawerLayout.close()
                true
            }


                else -> false
            }
        }


    }
}