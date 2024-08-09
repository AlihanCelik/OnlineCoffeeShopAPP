package com.example.onlincecoffeeshopapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlincecoffeeshopapp.Model.CategoryModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeViewModel:ViewModel() {
    private val firebaseDatabase=FirebaseDatabase.getInstance()
    private val _category=MutableLiveData<MutableList<CategoryModel>>()
    val category:LiveData<MutableList<CategoryModel>> = _category
    fun loadCategoyr(){
        val Ref=firebaseDatabase.getReference("Category")
        Ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var lists= mutableListOf<CategoryModel>()
                for(childSnapshot in snapshot.children){
                    val list=childSnapshot.getValue(CategoryModel::class.java)
                    if(list!=null){
                        lists.add(list)
                    }
                }
                _category.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
}