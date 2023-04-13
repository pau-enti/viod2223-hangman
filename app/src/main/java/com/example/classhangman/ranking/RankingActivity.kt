package com.example.classhangman.ranking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import com.example.classhangman.databinding.ActivityGameBinding
import com.example.classhangman.databinding.ActivityRankingBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class RankingActivity : AppCompatActivity() {
    lateinit var binding: ActivityRankingBinding
    lateinit var adapter: RankingAdapter

    private val rankingViewModel: RankingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RankingAdapter()
        binding.rankingList.adapter = adapter

        rankingViewModel.shownRanking.observe(this) {
            adapter.updateRankingValues(it)
        }

        rankingViewModel.loadRanking()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
//                if (newText != null)
//                    rankingViewModel.preformSearch(newText)

                newText?.let {
                    rankingViewModel.preformSearch(it)
                }

                return true
            }
        })
    }
}