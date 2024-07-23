/*
 * MIT License
 *
 * Copyright (c) 2024 Giuseppe Calabrese
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package it.github.bankaccountmanager.bank;

import it.github.bankaccountmanager.user.Client;

/**
 * @author Giuseppe Calabrese
 */

public class BankAccount {
  private double saldo;
  private int deposita;
  private int prelievo;
  private double saldomassimo;

  public BankAccount(double saldo, Client proprietario, double contoMax) throws Exception {
    if(saldo >= 0)  this.saldo = saldo;
    else {
      System.out.println();
      throw new Exception("Non è possibile creare conti correnti con saldo negativo!" + "\n"
        + "\n" + "Fare molta attenzione!"  + "\n" + "\n" + "Il saldo errato è il seguente: "
        + saldo);
    }
    if(saldomassimo < 0) throw new Exception("Impossiible impostare il saldo più alto negativo!");
    this.saldomassimo = contoMax;
  }

  public double get_saldo() {
    return saldo;
  }
  public int set_deposita(int deposita) {
    return this.deposita = deposita;
  }
  public int depositoTOT() {
    deposita = (int) (deposita + saldo);
    saldo = deposita;
    return deposita;
  }
  public int set_prelievo(int prelievo) {
    return this.prelievo = prelievo;
  }

  public int prelievo_Aggiornato() {
    int sottrazione = (int) saldo - prelievo;
    saldo = sottrazione;
    return (int) saldo;
  }
  public void setSaldoMax(double max) {
    saldomassimo = max;
  }
  public double get_saldo_massimo() {
    return saldomassimo;
  }
}

