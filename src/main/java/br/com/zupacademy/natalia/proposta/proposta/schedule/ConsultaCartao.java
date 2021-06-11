package br.com.zupacademy.natalia.proposta.proposta.schedule;

import br.com.zupacademy.natalia.proposta.proposta.dto.CartaoClientResponse;
import br.com.zupacademy.natalia.proposta.proposta.entities.Cartao;
import br.com.zupacademy.natalia.proposta.proposta.entities.Proposta;
import br.com.zupacademy.natalia.proposta.proposta.repositories.CartaoRepository;
import br.com.zupacademy.natalia.proposta.proposta.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import br.com.zupacademy.natalia.proposta.proposta.apiclient.cartoes.GeraCartaoClient;

@Component
public class ConsultaCartao {

    @Autowired
    PropostaRepository propostaRepository;

    @Autowired
    GeraCartaoClient geraCartaoClient;

    @Autowired
    CartaoRepository cartaoRepository;

    @Scheduled(fixedRate = 5000)
    public void analisaPropostasPeriodicamente() {
        Iterable<Proposta> result = propostaRepository.findAll();

        result.forEach(proposta -> {
            if (proposta.getCartao() == null) {
                CartaoClientResponse cartao = geraCartaoClient.enviaDadosParaNovoCartao(proposta.getId());
                proposta.setCartao(cartao.getId());
                Cartao salva = cartao.converter(cartao);
                salva.setTitular(proposta.getNome());
                cartaoRepository.save(salva);

                propostaRepository.save(proposta);
            }
        });
    }

}
