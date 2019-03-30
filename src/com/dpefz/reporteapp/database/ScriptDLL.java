package com.dpefz.reporteapp.database;



public class ScriptDLL {

	public static String getCreateTableReports() {
		StringBuilder sql = new StringBuilder();
		sql.append("create table if not exists reports( ");
		sql.append("idReport integer primary key autoincrement not null, ");
		sql.append("descricaoReport text(200) not null default(''), ");
		sql.append("nomeFuncionario text(40) not null default(''), ");
		sql.append("apelidoFuncionario text(40) not null default(''), ");
		sql.append("departamento text(70) not null default(''), ");
		sql.append("data text(10) not null default(''), ");
		sql.append("hora text(5) not null default(''), ");
		sql.append("piso integer not null default('') );");
		return sql.toString();
	}
	
	public static String getCreateTableFuncionario(){
		StringBuilder sql = new StringBuilder();
		sql.append("create table if not exists funcionario( ");
		sql.append("idFuncionario integer primary key autoincrement not null, ");
		sql.append("codigoFuncionario varchar(5) unique not null default(''), ");
		sql.append("nomeFuncionario varchar(40) not null default(''), ");
		sql.append("apelidoFuncionario varchar(40) not null default(''), ");
		sql.append("departamento varchar(70) not null default(''), ");
		sql.append("reparticao varchar(70) not null default(''), ");
		sql.append("cargo varchar(50) not null default(''), ");
		sql.append("carreira varchar(50) not null default(''), ");
		sql.append("dataRegisto text not null default(''));");
		return sql.toString();
		
		
	}

	public static String getCreateTableUsuario() {
		StringBuilder sql = new StringBuilder();
		sql.append("create table if not exists usuario( ");
		sql.append("idUser integer primary key autoincrement not null, ");
		sql.append("codigoFuncionario integer(10)not null unique, ");
		sql.append("usuario varchar(10) not null default(''), ");
		sql.append("senha varchar(10) not null default(''), ");
		sql.append("foreign key(codigoFuncionario) references funcionario(codigoFuncionario));");
		return sql.toString();
	}
	
	

}
