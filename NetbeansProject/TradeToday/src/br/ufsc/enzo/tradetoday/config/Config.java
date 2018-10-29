/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.enzo.tradetoday.config;

/**
    Configuration Handler for TradeToday

Inteface :
    @param setRefreshRate(String refreshRate)
    @param setRankingAlgorithm(String rankingAlgorithm)
    @param setCustomKey(String customKey)
    @param getConfig()
        
*/
public class Config {
    // Static default values
    public static final String DEFAULT_REFRESH_RATE = "Daily";
    public static final String DEFAULT_RANKING_ALGORITHM = "MovingAverage";
    public static final String DEFAULT_CUSTOM_KEY = "";
    public static final String REFRESH_DAILY = "Daily";
    public static final String REFRESH_WEEKLY = "Weekly";
    public static final String REFRESH_MONTHLY = "Mothly";
    public static final String RANKING_AVERAGE = "MovingAverage";
    public static final String RANKING_BOLLINGER = "BollingerBand";
    
    // Headers on CSV File | Configurations
    private String refreshRate;
    private String rankingAlgorithm;
    private String customKey;
    
    
    Config() {
        //Only for instancy on ConfigHandler
    }
    
    Config(String refreshRate,String rankingAlgorithm,String customKey){
        this.refreshRate = refreshRate;
        this.rankingAlgorithm = rankingAlgorithm;
        this.customKey = customKey;
    }
    
    void update(String refreshRate,String rankingAlgorithm,String customKey) {
        this.refreshRate = refreshRate;
        this.rankingAlgorithm = rankingAlgorithm;
        this.customKey = customKey;
    }
    
    public String getRefreshRate() {
        return refreshRate;
    }
    
    public String getRankingAlgorithm() {
        return rankingAlgorithm;
    }
    
    public String getCustomKey() {
        return customKey;
    }
    
    public static String[] getRefreshTimes(){
       String[] r = {REFRESH_DAILY,REFRESH_MONTHLY,REFRESH_WEEKLY};
       return r;
    }
    
    public static String[] getRankingAlgorithms(){
        String[] r = {RANKING_AVERAGE,RANKING_BOLLINGER};
        return r;
    }
     
}
