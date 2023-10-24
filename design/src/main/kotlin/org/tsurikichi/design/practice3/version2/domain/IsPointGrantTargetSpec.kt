package org.tsurikichi.design.practice3.version2.domain

class IsPointGrantTargetSpec {
    fun execute(rank: Rank, campaign: Campaign): Boolean {
        if (campaign.pointRate == null) return false
        if (RankType.BRONZE == rank.rankType) return false
        return true
    }
}
