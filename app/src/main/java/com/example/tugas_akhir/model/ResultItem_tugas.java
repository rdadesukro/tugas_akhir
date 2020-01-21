package com.example.tugas_akhir.model;


import com.google.gson.annotations.SerializedName;


public class ResultItem_tugas {

	@SerializedName("nama")
	private String nama;

	@SerializedName("foto")
	private String foto;

	@SerializedName("id")
	private String id;

	@SerializedName("ket")
	private String ket;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setKet(String ket){
		this.ket = ket;
	}

	public String getKet(){
		return ket;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem_tugas{" +
			"nama = '" + nama + '\'' + 
			",foto = '" + foto + '\'' + 
			",id = '" + id + '\'' + 
			",ket = '" + ket + '\'' + 
			"}";
		}
}