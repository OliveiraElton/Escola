package br.com.proway.senior.escola.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.escola.model.Aluno;
import br.com.proway.senior.escola.model.Materia;
import br.com.proway.senior.escola.model.Prova;

public class ProvaControllerTest {

	static ProvaController controllerProva;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aluno aluno = new Aluno();
		Integer periodo = 202105;
		Prova prova = new Prova(periodo, aluno, null);
		controllerProva = new ProvaController(prova);
	}

	@Test
	public void testProvaControllerProva() {
		assertNotNull(controllerProva);
	}

	@Test
	public void testAddProva() {
		controllerProva.addProva();
		Materia materia = new Materia();
		Prova prova = new Prova(202105, controllerProva.getProva().getAluno(),
				materia);
		controllerProva.addProva();
		assertEquals(1, (int) controllerProva.getProva().getPeriodo());
	}

	@Test
	public void testRemoveProva() {
		Materia materia = new Materia();
		Prova prova = controllerProva.getProva();
		prova = new Prova(202105, prova.getAluno(), materia);
		controllerProva.removeProva();
		controllerProva.addProva();
		controllerProva.addProva();
		controllerProva.removeProva();
		controllerProva.getProva().getPeriodo();
		assertEquals(1, Integer.SIZE);

	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

}
