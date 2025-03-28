package Map;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Collection;
import java.util.HashMap;

public class AgendaEventos {
	private Map<LocalDate, Evento> eventosMap;
	
	public AgendaEventos() {this.eventosMap = new HashMap<>();}
	
	public void AdicionarEvento(LocalDate data, String nome, String atracao) {
		Evento evento = new Evento(nome, atracao);
		eventosMap.put(data, evento);
	}
	
	public void exibirAgenda() {
		Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap); // É organizado de forma crescente pois o LocalDate herda uma classe que implementa o Comparable
		System.out.println(eventosTreeMap);
	}
	
	public void obterProximoEvento() {
//		Set<LocalDate> dateSet =  eventosMap.keySet(); // retorna todas as chaves do Map
//		Collection<Evento> values = eventosMap.values();
		
		Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
		LocalDate dataAtual = LocalDate.now();
		
		for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) { // entrySet retorna um set onde cada elemento é do tipo Map.Entry, que pode ser utilizado para apontar as chaves e os valores.
			if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) { // O evento é hoje ou depois de hoje
				System.out.println("O próximo evento: " + entry.getValue() + " acontecerá na data " + entry.getKey());
			}
		}
	}
	
	public static void main(String[] arg) {
		AgendaEventos agendaEventos = new AgendaEventos();
		
		agendaEventos.AdicionarEvento(LocalDate.of(2025, Month.APRIL,29), "Evento 2", "Atração 2");
		agendaEventos.AdicionarEvento(LocalDate.of(2025, Month.OCTOBER,26), "Evento 3", "Atração 4");
		agendaEventos.AdicionarEvento(LocalDate.of(2025, Month.MARCH,25), "Evento 1", "Atração 1");
		
		agendaEventos.exibirAgenda();
		agendaEventos.obterProximoEvento();
		
	}
}
