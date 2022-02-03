package com.example.android.multiactivitygithubsearch

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.android.multiactivitygithubsearch.data.GitHubRepo

const val EXTRA_GITHUB_REPO = "GitHubRepo"

class RepoDetailActivity : AppCompatActivity() {
    private var repo: GitHubRepo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_detail)

        if (intent != null && intent.hasExtra(EXTRA_GITHUB_REPO)) {
            repo = intent.getSerializableExtra(EXTRA_GITHUB_REPO) as GitHubRepo
            findViewById<TextView>(R.id.tv_repo_name).text = repo!!.name
            findViewById<TextView>(R.id.tv_repo_stars).text = repo!!.stars.toString()
            findViewById<TextView>(R.id.tv_repo_description).text = repo!!.description
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_repo_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_view_repo -> {
                viewRepoOnWeb()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun viewRepoOnWeb() {
        if (repo != null) {
            val uri = Uri.parse(repo!!.url)
            val intent: Intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        }
    }
}