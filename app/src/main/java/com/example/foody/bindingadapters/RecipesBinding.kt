package com.example.foody.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.foody.data.database.RecipesEntity
import com.example.foody.models.FoodRecipe
import com.example.foody.util.NetworkResult

class RecipesBinding {

    companion object{

        @BindingAdapter("readApiResponse", "readDatabase", requireAll = true)
        @JvmStatic
        fun errorImageViewVisibility(
            errorImageView: ImageView,
            apiResponse: NetworkResult<FoodRecipe>?,
            database: List<RecipesEntity>?
        ){
            if(apiResponse is NetworkResult.Error && database.isNullOrEmpty()) {
                errorImageView.visibility = View.VISIBLE
            } else if(apiResponse is NetworkResult.Loading || apiResponse is NetworkResult.Success){
                errorImageView.visibility = View.INVISIBLE
            }
        }

        @BindingAdapter("readApiResponse2", "readDatabase2", requireAll = true)
        @JvmStatic
        fun errorTextViewVisibility(
            errorTextView: TextView,
            apiResponse: NetworkResult<FoodRecipe>?,
            database: List<RecipesEntity>?
        ){
            if(apiResponse is NetworkResult.Error && database.isNullOrEmpty()) {
                errorTextView.visibility = View.VISIBLE
            } else if(apiResponse is NetworkResult.Loading || apiResponse is NetworkResult.Success){
                errorTextView.visibility = View.INVISIBLE
            }
        }

    }

}