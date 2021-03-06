package edu.gwu.gwtrivia.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import edu.gwu.gwtrivia.utils.PersistanceManager
import edu.gwu.gwtrivia.R
import edu.gwu.gwtrivia.adapter.ScoresAdapter
import edu.gwu.gwtrivia.model.Score
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_scores.*

class ScoresActivity : AppCompatActivity() {
    private lateinit var persistanceManager: PersistanceManager
    private lateinit var scoresAdapter: ScoresAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)

        //setup toolbar
        setSupportActionBar(scores_toolbar)

        //initialize persistance manager
        persistanceManager = PersistanceManager(this)

        //fetch scores
        val scores = persistanceManager.fetchScores()

        //initialize adapter with scores
        scoresAdapter = ScoresAdapter(scores)

        //setup recycler view's layout manager and adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = scoresAdapter
    }

    fun showMap(item: MenuItem) {
        //take user to map activity
        val intent = Intent(this, MapActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.score, menu)

        return true
    }
}