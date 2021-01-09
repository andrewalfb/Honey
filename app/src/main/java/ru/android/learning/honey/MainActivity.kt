package ru.android.learning.honey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity(), ClickListener {
    private val listMoviesFragment = FragmentMoviesList()

    private val detailsMovieFragment = FragmentMoviesDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .apply {
                    add(R.id.movie_list_fragment, listMoviesFragment)
                    commit()
                }
        }
    }

    private fun moveToNextScreen() {
        val intent = Intent(this, MovieDetailsActivity::class.java)

        startActivity(intent)
    }

    override fun onItemClick() {
        Log.i("Click", "clicked ")
        supportFragmentManager.beginTransaction()
            .replace(R.id.movie_list_fragment, detailsMovieFragment)
            .addToBackStack(null)
            .commit()
    }
}